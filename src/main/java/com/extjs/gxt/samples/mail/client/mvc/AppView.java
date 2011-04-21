/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.mail.client.mvc;

import com.extjs.gxt.samples.mail.client.AppEvents;
import com.extjs.gxt.samples.mail.client.widget.LoginDialog;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.RootPanel;

public class AppView extends View {

  public static final String WEST_PANEL = "west";
  public static final String VIEWPORT = "viewport";
  public static final String CENTER_PANEL = "center";

  private Viewport viewport;
  private ContentPanel west;
  private LayoutContainer center;

  public AppView(Controller controller) {
    super(controller);
  }

  protected void initialize() {
    LoginDialog dialog = new LoginDialog();
    dialog.setClosable(false);
    dialog.addListener(Events.Hide, new Listener<WindowEvent>() {
      public void handleEvent(WindowEvent be) {
        Dispatcher.forwardEvent(AppEvents.Init);
      }
    });
    dialog.show();
  }

  private void initUI() {
    viewport = new Viewport();
    viewport.setLayout(new BorderLayout());

    createNorth();
    createWest();
    createCenter();

    // registry serves as a global context
    Registry.register(VIEWPORT, viewport);
    Registry.register(WEST_PANEL, west);
    Registry.register(CENTER_PANEL, center);

    RootPanel.get().add(viewport);
  }

  private void createNorth() {
    StringBuffer sb = new StringBuffer();
    sb.append("<div id='demo-header' class='x-small-editor'><div id='demo-theme'></div><div id=demo-title>Ext GWT Mail Demo</div></div>");

    HtmlContainer northPanel = new HtmlContainer(sb.toString());
    northPanel.setStateful(false);

    BorderLayoutData data = new BorderLayoutData(LayoutRegion.NORTH, 33);
    data.setMargins(new Margins());
    viewport.add(northPanel, data);
  }

  private void createWest() {
    BorderLayoutData data = new BorderLayoutData(LayoutRegion.WEST, 200, 150, 350);
    data.setMargins(new Margins(5, 0, 5, 5));

    west = new ContentPanel();
    west.setBodyBorder(false);
    west.setLayout(new AccordionLayout());
    west.setLayoutOnChange(true);
    west.setHeading("GXT Mail Demo");

    viewport.add(west, data);
  }

  private void createCenter() {
    center = new LayoutContainer();
    center.setLayout(new FitLayout());

    BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
    data.setMargins(new Margins(5, 5, 5, 5));

    viewport.add(center, data);
  }

  protected void handleEvent(AppEvent event) {
    if (event.getType() == AppEvents.Init) {
      initUI();
    }
  }

}
