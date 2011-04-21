/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.explorer.client.mvc;

import com.extjs.gxt.samples.explorer.client.AppEvents;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

public class AppController extends Controller {

  private AppView appView;

  public AppController() {
    appView = new AppView(this);

    registerEventTypes(AppEvents.Init);
  }

  public void handleEvent(AppEvent event) {
    if (event.getType() == AppEvents.Init) {
      forwardToView(appView, event);
    }
  }

}
