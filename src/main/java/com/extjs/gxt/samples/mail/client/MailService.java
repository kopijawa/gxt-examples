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
import com.google.gwt.user.client.rpc.RemoteService;

public interface MailService extends RemoteService {

  public Folder getMailFolders(String userId);

  public List<MailItem> getMailItems(Folder folder);

}
