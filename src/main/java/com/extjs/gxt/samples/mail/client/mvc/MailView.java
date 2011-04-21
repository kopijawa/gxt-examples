/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.mail.client.mvc;

import java.util.List;

import com.extjs.gxt.samples.mail.client.AppEvents;
import com.extjs.gxt.samples.mail.client.widget.MailItemPanel;
import com.extjs.gxt.samples.mail.client.widget.MailListPanel;
import com.extjs.gxt.samples.resources.client.model.Folder;
import com.extjs.gxt.samples.resources.client.model.MailItem;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;

public class MailView extends View {

  private LayoutContainer container;
  private MailListPanel mailListPanel;
  private MailItemPanel mailItemPanel;

  public MailView(Controller controller) {
    super(controller);
  }

  @Override
  protected void handleEvent(AppEvent event) {
    if (event.getType() == AppEvents.NavMail) {
      LayoutContainer wrapper = (LayoutContainer) Registry.get(AppView.CENTER_PANEL);
      wrapper.removeAll();
      wrapper.add(container);
      wrapper.layout();
      return;
    }

    if (event.getType() == AppEvents.ViewMailItems) {
      Folder f = (Folder) event.getData("folder");
      mailListPanel.setHeading(f.getName());
      
      ListStore<MailItem> store = mailListPanel.getStore();
      store.removeAll();
   
      store.add(event.<List<MailItem>>getData());

      //wrapper.layout();

      List<MailItem> items = event.getData();
      if (items.size() > 0) {
        mailListPanel.getGrid().getSelectionModel().select(((MailItem) items.get(0)), false);
      } else {
        mailItemPanel.showItem(null);
      }
      return;
    }

    if (event.getType() == AppEvents.ViewMailItem) {
      MailItem item = event.getData();
      mailItemPanel.showItem(item);
    }
  }

  @Override
  protected void initialize() {
    container = new LayoutContainer();

    BorderLayout layout = new BorderLayout();
    layout.setEnableState(false);
    container.setLayout(layout);

    mailListPanel = new MailListPanel();
    container.add(mailListPanel, new BorderLayoutData(LayoutRegion.CENTER));

    mailItemPanel = new MailItemPanel();
    BorderLayoutData southData = new BorderLayoutData(LayoutRegion.SOUTH, .5f, 200, 1000);
    southData.setSplit(true);
    southData.setMargins(new Margins(5, 0, 0, 0));
    container.add(mailItemPanel, southData);
  }

}
