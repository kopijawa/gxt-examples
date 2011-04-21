/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.explorer.client;

import com.extjs.gxt.samples.client.ExampleService;
import com.extjs.gxt.samples.client.ExampleServiceAsync;
import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.client.FileService;
import com.extjs.gxt.samples.client.FileServiceAsync;
import com.extjs.gxt.samples.client.examples.model.Entry;
import com.extjs.gxt.samples.explorer.client.mvc.AppController;
import com.extjs.gxt.samples.explorer.client.mvc.ContentController;
import com.extjs.gxt.samples.explorer.client.mvc.NavigationController;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class Explorer implements EntryPoint {

  private Dispatcher dispatcher;
  private ExplorerModel model;

  public void onModuleLoad() {
    if (!GWT.isScript()) {
      GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
        public void onUncaughtException(Throwable e) {
          e.printStackTrace();
        }
      });
    }
    ExampleServiceAsync service = (ExampleServiceAsync) GWT.create(ExampleService.class);
    ServiceDefTarget endpoint = (ServiceDefTarget) service;
    String moduleRelativeURL = Examples.SERVICE;
    endpoint.setServiceEntryPoint(moduleRelativeURL);
    Registry.register(Examples.SERVICE, service);

    FileServiceAsync fileservice = (FileServiceAsync) GWT.create(FileService.class);
    endpoint = (ServiceDefTarget) fileservice;
    moduleRelativeURL = Examples.FILE_SERVICE;
    endpoint.setServiceEntryPoint(moduleRelativeURL);
    Registry.register(Examples.FILE_SERVICE, fileservice);

    model = new ExplorerModel();
    Registry.register(Examples.MODEL, model);

    if ("access".equals(GXT.getThemeId())) {
      Timer t = new Timer() {
        @Override
        public void run() {
          buildApp();
        }
      };
      t.schedule(500);
    } else {
      buildApp();
    }
  }

  private void buildApp() {
    dispatcher = Dispatcher.get();
    dispatcher.addController(new AppController());
    dispatcher.addController(new NavigationController());
    dispatcher.addController(new ContentController());
    dispatcher.dispatch(AppEvents.Init);

    String hash = Window.Location.getHash();

    showPage(model.findEntry("overview"));

    if (!"".equals(hash)) {
      hash = hash.substring(1);
      Entry entry = model.findEntry(hash);
      if (entry != null) {
        showPage(entry);
      }
    }
  }

  public static void showPage(Entry entry) {
    AppEvent appEvent = new AppEvent(AppEvents.ShowPage, entry);
    appEvent.setHistoryEvent(true);
    appEvent.setToken(entry.getId());
    Dispatcher.forwardEvent(appEvent);
  }

}
