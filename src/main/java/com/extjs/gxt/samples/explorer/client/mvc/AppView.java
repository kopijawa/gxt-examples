/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.explorer.client.mvc;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.custom.ThemeSelector;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.RootPanel;

public class AppView extends View {

  public static final String CENTER_PANEL = "centerPanel";
  public static final String WEST_PANEL = "westPanel";
  public static final String NORTH_PANEL = "northPanel";
  public static final String VIEWPORT = "viewPort";
  
  private Viewport viewport;
  private ContentPanel centerPanel;
  private HtmlContainer northPanel;
  private ContentPanel westPanel;

  public AppView(Controller controller) {
    super(controller);
  }

  protected void handleEvent(AppEvent event) {

  }

  protected void initialize() {
    viewport = new Viewport();
    viewport.setLayout(new BorderLayout());
    Registry.register(VIEWPORT, viewport);
    
    createNorth();
    createWest();
    createCenter();
    
    RootPanel.get().add(viewport);
    
  }

  private void createCenter() {
    centerPanel = new ContentPanel();
    centerPanel.setBorders(false);
    centerPanel.setHeaderVisible(false);
    centerPanel.setLayout(new FitLayout());

    BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
    data.setMargins(new Margins(5, 5, 5, 0));
    viewport.add(centerPanel, data);
    Registry.register(CENTER_PANEL, centerPanel);
  }

  private void createWest() {
    BorderLayoutData data = new BorderLayoutData(LayoutRegion.WEST, 220, 150, 320);
    data.setMargins(new Margins(5, 5, 5, 5));
    data.setCollapsible(true);
    westPanel = new ContentPanel();

    ToolBar toolBar = new ToolBar();
    westPanel.setTopComponent(toolBar);

    viewport.add(westPanel, data);
    Registry.register(WEST_PANEL, westPanel);
  }

  private void createNorth() {
    StringBuffer sb = new StringBuffer();
    sb.append("<div id='demo-theme'></div><div id=demo-title>Ext GWT Explorer Demo</div>");

    northPanel = new HtmlContainer(sb.toString());
    northPanel.setStateful(false);
    northPanel.setId("demo-header");
    northPanel.addStyleName("x-small-editor");

    ThemeSelector selector = new ThemeSelector();
    selector.setWidth(125);
    northPanel.add(selector, "#demo-theme");

    BorderLayoutData data = new BorderLayoutData(LayoutRegion.NORTH, 33);
    data.setMargins(new Margins());
    viewport.add(northPanel, data);
    Registry.register(NORTH_PANEL, northPanel);
  }

}
