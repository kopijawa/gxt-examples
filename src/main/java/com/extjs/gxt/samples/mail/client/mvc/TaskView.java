/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.mail.client.mvc;

import com.extjs.gxt.samples.mail.client.AppEvents;
import com.extjs.gxt.samples.mail.client.widget.TaskPanel;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.LayoutContainer;

public class TaskView extends View {

  private TaskPanel panel;

  public TaskView(Controller controller) {
    super(controller);
  }

  @Override
  protected void initialize() {
    panel = new TaskPanel();
  }

  @Override
  protected void handleEvent(AppEvent event) {
    if (event.getType() == AppEvents.NavTasks) {
      LayoutContainer wrapper = (LayoutContainer) Registry.get(AppView.CENTER_PANEL);
      wrapper.removeAll();
      wrapper.add(panel);
      wrapper.layout();
    }
  }
}
