/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.mail.client.widget;

import com.extjs.gxt.samples.resources.client.model.MailItem;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class MailItemPanel extends ContentPanel {

  private ContentPanel content;
  private Html header;
  private String headerHTML = "<div class=mail-item-detail><h1>{0}</h1><h2><b>From:</b> {1}</h2><h3><b>To:</b> {2}</h3></div>";

  public MailItemPanel() {
    setHeaderVisible(false);
    setLayout(new FitLayout());

    content = new ContentPanel();
    content.setBodyBorder(false);
    content.setHeaderVisible(false);
    content.setScrollMode(Scroll.AUTO);

    header = new Html();
    header.setStyleName("mail-item-detail");
    content.setTopComponent(header);

    add(content);
  }

  public void showItem(MailItem item) {
    if (item != null) {
      Params p = new Params();
      p.add(item.getSubject());
      p.add(item.getSender());
      p.add(item.getEmail());

      String s = Format.substitute(headerHTML, p);
      header.getElement().setInnerHTML(s);

      content.removeAll();
      content.addText("<div style='padding: 12px;font-size: 12px'>" + item.getBody() + "</div>");

      content.layout();

    } else {
      header.setHtml("");
      content.removeAll();
    }
  }

}
