/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.explorer.client.mvc;

import com.extjs.gxt.samples.explorer.client.AppEvents;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

public class NavigationController extends Controller {

  private NavigationView view;

  public NavigationController() {
    registerEventTypes(AppEvents.Init);
    registerEventTypes(AppEvents.HidePage);
    registerEventTypes(AppEvents.TabChange);
  }

  public void initialize() {
    view = new NavigationView(this);
  }

  public void handleEvent(AppEvent event) {
    EventType t = event.getType();
    if (t == AppEvents.Init || t == AppEvents.HidePage || t == AppEvents.TabChange) {
      forwardToView(view, event);
    }
  }

}
