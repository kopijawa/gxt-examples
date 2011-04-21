/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.mail.client.widget;

import java.util.Arrays;

import com.extjs.gxt.samples.mail.client.AppEvents;
import com.extjs.gxt.samples.resources.client.model.MailItem;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

public class MailListPanel extends ContentPanel {

  private Grid<MailItem> grid;
  private ListStore<MailItem> store;

  public MailListPanel() {
    setLayout(new FitLayout());

    ToolBar toolBar = new ToolBar();
    Button create = new Button("Create");
    create.setIcon(IconHelper.createStyle("icon-email-add"));
    toolBar.add(create);

    Button reply = new Button("Reply");
    reply.setIcon(IconHelper.createStyle("icon-email-reply"));
    toolBar.add(reply);

    setTopComponent(toolBar);

    ColumnConfig sender = new ColumnConfig("sender", "Sender", 200);
    ColumnConfig email = new ColumnConfig("email", "Email", 100);
    ColumnConfig subject = new ColumnConfig("subject", "Subject", 100);

    ColumnModel cm = new ColumnModel(Arrays.asList(sender, email, subject));

    store = new ListStore<MailItem>();

    grid = new Grid<MailItem>(store, cm);
    grid.getView().setForceFit(true);
    grid.getSelectionModel().addSelectionChangedListener(
        new SelectionChangedListener<MailItem>() {
          @Override
          public void selectionChanged(SelectionChangedEvent<MailItem> se) {
            MailItem m = se.getSelectedItem();
            showMailItem(m);
          }
        });

    add(grid);

  }

  public ListStore<MailItem> getStore() {
    return store;
  }

  public Grid<MailItem> getGrid() {
    return grid;
  }

  private void showMailItem(MailItem item) {
    AppEvent evt = new AppEvent(AppEvents.ViewMailItem, item);
    Dispatcher.forwardEvent(evt);
  }

}
