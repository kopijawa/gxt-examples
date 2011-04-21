/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.mail.server;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.samples.mail.client.MailService;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Folder;
import com.extjs.gxt.samples.resources.client.model.MailItem;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MailServiceImpl extends RemoteServiceServlet implements MailService {

  private Folder mail;
  private List<MailItem> inboxItems;
  private List<MailItem> sentItems;
  private List<MailItem> trashItems;

  public MailServiceImpl() {
    mail = new Folder();
    Folder inbox = new Folder("Inbox");
    Folder sent = new Folder("Sent Items");
    Folder trash = new Folder("Trash");

    List<MailItem> items = TestData.getMailItems();
    int count = items.size();

    inboxItems = new ArrayList<MailItem>();
    sentItems = new ArrayList<MailItem>();
    trashItems = new ArrayList<MailItem>();

    for (int i = 0; i < count; i++) {
      MailItem item = (MailItem) items.get(i);
      if (i < (count / 2)) {
        inboxItems.add(item);
      } else {
        sentItems.add(item);
      }
    }

    mail.add(inbox);
    mail.add(sent);
    mail.add(trash);
  }

  public Folder getMailFolders(String userId) {
    return mail;
  }

  public List<MailItem> getMailItems(Folder folder) {
    String name = folder.getName();
    if (name.equals("Inbox")) {
      return inboxItems;
    } else if (name.equals("Sent Items")) {
      return sentItems;
    } else if (name.equals("Trash")) {
      return trashItems;
    }
    return new ArrayList<MailItem>();
  }

}
