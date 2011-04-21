/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.mail.client.mvc;

import com.extjs.gxt.samples.mail.client.AppEvents;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.ContentPanel;

public class ContactFolderView extends View {

  private ContentPanel contacts;

  public ContactFolderView(Controller controller) {
    super(controller);
  }

  @Override
  protected void initialize() {

  }

  protected void initUI() {
    contacts = new ContentPanel();
    contacts.setHeading("Contacts");
    contacts.setAnimCollapse(false);
    contacts.addListener(Events.Expand, new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent be) {
        Dispatcher.get().dispatch(AppEvents.NavContacts);
      }
    });

    ContentPanel west = (ContentPanel) Registry.get(AppView.WEST_PANEL);
    west.add(contacts);
  }

  @Override
  protected void handleEvent(AppEvent event) {
    if (event.getType() == AppEvents.Init) {
      initUI();
    }
  }

}
