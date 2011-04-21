/*
 * Ext GWT 2.2.1 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.explorer.client.pages;

import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.client.ExamplesModel;
import com.extjs.gxt.samples.client.examples.model.Entry;
import com.extjs.gxt.samples.explorer.client.Explorer;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.google.gwt.user.client.Element;

public class OverviewPage extends LayoutContainer {

  private ListView<ModelData> dataView;

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);

    setScrollMode(Scroll.AUTO);

    ExamplesModel model = (ExamplesModel) Registry.get(Examples.MODEL);
    ListStore<ModelData> store = new ListStore<ModelData>();
    store.add(model.getEntries());

    StringBuffer sb = new StringBuffer();
    sb.append("<tpl for=\".\">");
    sb.append("<div class='sample-box' style='padding-top: 4px'>");
    sb.append("<div class='thumbd'>{image}</div>");
    sb.append("<div>{name}</div>");
    sb.append("</div></tpl>");

    dataView = new ListView<ModelData>();
    dataView.addStyleName("overview-page");
    dataView.setItemSelector(".sample-box");
    dataView.setOverStyle("sample-over");
    dataView.setSelectStyle("none");
    dataView.setBorders(false);
    dataView.setStore(store);
    dataView.setTemplate(sb.toString());
    dataView.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<ModelData>() {
    
      @Override
      public void selectionChanged(SelectionChangedEvent<ModelData> se) {
        if (se.getSelectedItem() != null) {
          ModelData record = se.getSelectedItem();
          Entry entry = (Entry) record;
          Explorer.showPage(entry);
          dataView.getSelectionModel().deselectAll();
        }
      }
    });
    add(dataView);
  }
}
