/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.mail.client;

import java.util.List;

import com.extjs.gxt.samples.resources.client.model.Folder;
import com.extjs.gxt.samples.resources.client.model.MailItem;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MailServiceAsync {

  public void getMailFolders(String userId, AsyncCallback<Folder> callback);

  public void getMailItems(Folder folder, AsyncCallback<List<MailItem>> callback);
}
