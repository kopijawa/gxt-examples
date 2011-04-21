/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.mail.client;

import com.extjs.gxt.samples.mail.client.mvc.AppController;
import com.extjs.gxt.samples.mail.client.mvc.ContactController;
import com.extjs.gxt.samples.mail.client.mvc.MailController;
import com.extjs.gxt.samples.mail.client.mvc.TaskController;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.util.Theme;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class Mail implements EntryPoint {

  public static final String SERVICE = "mailservice";
  
  public void onModuleLoad() {
    GXT.setDefaultTheme(Theme.GRAY, true);

    MailServiceAsync service = (MailServiceAsync) GWT.create(MailService.class);
    ServiceDefTarget endpoint = (ServiceDefTarget) service;
    String moduleRelativeURL = SERVICE;
    endpoint.setServiceEntryPoint(moduleRelativeURL);
    Registry.register(SERVICE, service);

    Dispatcher dispatcher = Dispatcher.get();
    dispatcher.addController(new AppController());
    dispatcher.addController(new MailController());
    dispatcher.addController(new TaskController());
    dispatcher.addController(new ContactController());

    dispatcher.dispatch(AppEvents.Login);
    
    GXT.hideLoadingPanel("loading");
  }

}
