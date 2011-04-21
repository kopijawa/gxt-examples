/*
 * Ext GWT Library
 * Copyright(c) 2006-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

SamplePanel = Ext.extend(Ext.DataView, {
    autoHeight: true,
    frame:true,
    cls:'demos',
    itemSelector: 'dd',
    overClass: 'over',
    
    tpl : new Ext.XTemplate(
        '<div id="sample-ct">',
            '<tpl for=".">',
            '<div><a name="{id}"></a><h2><div>{title}</div></h2>',
            '<dl>',
                '<tpl for="samples">',
                    '<dd ext:url="{url}"><img src="samples/images/thumbs/{icon}"/>',
                        '<div><h4>{text}</h4><p>{desc}</p></div>',
                    '</dd>',
                '</tpl>',
            '<div style="clear:left"></div></dl></div>',
            '</tpl>',
        '</div>'
    ),

    onClick : function(e){
        var group = e.getTarget('h2', 3, true);
        if(group){
            group.up('div').toggleClass('collapsed');
        }else {
            var t = e.getTarget('dd', 5, true);
            if(t && !e.getTarget('a', 2)){
                var url = t.getAttributeNS('ext', 'url');
                window.open(url);
            }
        }
        return SamplePanel.superclass.onClick.apply(this, arguments);
    }
});


Ext.EventManager.on(window, 'load', function(){
    var catalog = [{
        title: 'Combination Samples',
        samples: [{
            text: 'Explorer Demo',
            url: 'explorer.html',
            icon: 'explorer.gif',
            desc: 'Explore the Ext GWT Components and quickly view the source code to see the API in action.'
        },{
            text: 'Mail App',
            url: 'mail.html',
            icon: 'mail.gif',
            desc: 'A mail application with a preview pane that retrieves data using the Ext GWT data loading API.'
        },{
            text: 'Web Desktop',
            url: 'desktop.html',
            icon: 'desktop.gif',
            desc: 'Demonstrates how one could build a desktop in the browser using Ext components including a module plugin system.'
        }]
    },{
        title: 'Grids',
        samples: [{
            text: 'Basic Grid',
            url: 'pages/grid/grid.html',
            icon: 'basicgrid.gif',
            desc: 'A basic read-only grid loaded from local data that demonstrates the use of custom column renderers.'
        },{
            text: 'Column Grouping',
            url: 'pages/grid/columngrouping.html',
            icon: 'columngrouping.gif',
            desc: 'Grid and TreeGrid support multi-row column headers with rowspan and colspan support.'
        },{
            text: 'Aggregation Rows',
            url: 'pages/grid/aggregationrows.html',
            icon: 'aggregationrowgrid.gif',
            desc: 'One to many aggregation rows can be appended to a Grid and TreeGrid with built in support for column value calculations.'
        },{
            text: 'Grid Plugins',
            url: 'pages/grid/plugins.html',
            icon: 'gridplugins.gif',
            desc: 'Multiple grids customized via plugins: expander rows, checkbox selection and row numbering.'
        },{  
            text: 'Editable Grid',
            url: 'pages/grid/editable.html',
            icon: 'editablegrid.gif',
            desc: 'An editable grid loaded from local data that shows multiple types of grid editors.'
        },{
            text: 'RowEditor Grid',
            url: 'pages/grid/roweditor.html',
            icon: 'roweditorgrid.gif',
            desc: 'Edit a row in a Grid and TreeGrid at one time.'
        },{
            text: 'XML Grid',
            url: 'pages/grid/xml.html',
            icon: 'xmlgrid.gif',
            desc: 'A simple read-only grid loaded from XML data.'
        },{
            text: 'JSON Grid',
            url: 'pages/grid/json.html',
            icon: 'jsongrid.gif',
            desc: 'A simple read-only grid loaded from JSON data.'
        },{
            text: 'Paging',
            url: 'pages/grid/paging.html',
            icon: 'paging.gif',
            desc: 'A grid with server side paging, using GWT RPC.'
        },{
            text: 'Local Paging',
            url: 'pages/grid/localpaging.html',
            icon: 'localpaging.gif',
            desc: 'A grid with pages a local data (no server side calls).'
        },{
            text: 'Grouping',
            url: 'pages/grid/grouping.html',
            icon: 'grouping.gif',
            desc: 'A basic grouping grid showing collapsible data groups that can be customized via the "Group By" header menu option.'
        },{
            text: 'Live Group Summary',
            url: 'pages/grid/totals.html',
            icon: 'livegroupsummary.gif',
            desc: 'Advanced grouping grid that allows cell editing and includes custom dynamic summary calculations.'
        },{
            text: 'Buffered Grid',
            url: 'pages/grid/buffered.html',
            icon: 'bufferedgrid.gif',
            desc: 'Increasing grid performance by only rendering rows which are displayed.'
        },{
            text: 'Widget Renderer Grid',
            url: 'pages/grid/widgetrenderer.html',
            icon: 'widgetrenderergrid.gif',
            desc: 'Renders any widget into grid cells.'
        },{
            text: 'Filter Grid',
            url: 'pages/grid/gridfilters.html',
            icon: 'filtergrid.gif',
            desc: 'Adds typed filter fields into configured columns.'
        },{
            text: 'Live Grid',
            url: 'pages/grid/livegrid.html',
            icon: 'livegrid.gif',
            desc: 'Loads data on demand as the user scrolls.'
        }]
	    },{
	        title: 'TreeGrid',
	        samples: [{
	            text: 'Basic TreeGrid',
	            url: 'pages/treegrid/basic.html',
	            icon: 'basictreegrid.gif',
	            desc: 'A basic tree grid.'
	        },{
	            text: 'Filter TreeGrid',
	            url: 'pages/treegrid/filtertreegrid.html',
	            icon: 'filtertreegrid.gif',
	            desc: 'TreeGrid filtering.'
	        },{
	            text: 'Async TreeGrid',
	            url: 'pages/treegrid/asynctreegrid.html',
	            icon: 'asynctreegrid.gif',
	            desc: 'A tree grid which loads its children on-demand using GWT RPC.'
	        },{
	            text: 'RowNumber TreeGrid',
	            url: 'pages/treegrid/rownumber.html',
	            icon: 'rownumbertreegrid.gif',
	            desc: 'Adds row numbers to the tree grid.'
	        },{
	            text: 'EditorTreeGrid',
	            url: 'pages/treegrid/editortreegrid.html',
	            icon: 'editortreegrid.gif',
	            desc: 'An editable tree grid that shows multiple types of grid editors.'
	        },{
	            text: 'RowEditor TreeGrid',
	            url: 'pages/treegrid/roweditortreegrid.html',
	            icon: 'roweditortreegrid.gif',
	            desc: 'Edits a row in a tree grid at one time.'
	        },{
	            text: 'Widget Renderer TreeGrid',
	            url: 'pages/treegrid/widgetrenderer.html',
	            icon: 'widgetrenderertreegrid.gif',
	            desc: 'Renders any widget into grid cells.'
	        }]
	    },{
	        title: 'TreePanel',
	        samples: [{
	            text: 'Basic Tree',
	            url: 'pages/tree/basic.html',
	            icon: 'basictree.gif',
	            desc: 'A basic singl-select tree with custom icons.'
	        },{
	            text: 'Context Menu Tree',
	            url: 'pages/tree/contextmenu.html',
	            icon: 'contextmenutree.gif',
	            desc: 'A tree with custom context menu for adding and removing nodes.'
	        },{
	            text: 'Async Tree',
	            url: 'pages/tree/asynctree.html',
	            icon: 'asynctree.gif',
	            desc: 'A tree that loads its children on-demand user GWT RPC.'
	 		},{
	            text: 'Async XML Tree',
	            url: 'pages/tree/asyncxmltree.html',
	            icon: 'asyncxmltree.gif',
	            desc: 'A tree that loads its children on-demand using XML.'
	        },{
	            text: 'Filter Tree',
	            url: 'pages/tree/filter.html',
	            icon: 'filtertree.gif',
	            desc: 'A tree that filters its content based on the input in a store filter text field.'
			},{
	            text: 'Checkbox Tree',
	            url: 'pages/tree/checkbox.html',
	            icon: 'checkboxtree.gif',
	            desc: 'A tree with checkboxes that supports several check cascading modes.'
			},{
	            text: 'Fast Tree',
	            url: 'pages/tree/fasttree.html',
	            icon: 'fasttree.gif',
	            desc: 'Demonstrates great performing tree with a large number of nodes.'
	        }]
	    },{
        title: 'Tabs',
        samples: [{
            text: 'Basic Tabs',
            url: 'pages/tabs/tabs.html',
            icon: 'basictabs.gif',
            desc: 'Basic tab functionality including autoHeight, tabs from markup, Ajax loading and tab events.'
        },{
            text: 'Advanced Tabs',
            url: 'pages/tabs/advanced.html',
            icon: 'advancedtabs.gif',
            desc: 'Advanced tab features including tab scrolling, adding tabs programmatically.'
        }]
    },{
        title: 'Charts',
        samples: [{
            text: 'Basic Chart',
            url: 'pages/charts/basic.html',
            icon: 'basicchart.gif',
            desc: 'A basic chart example.'
        },{
            text: 'Chart Gallery',
            url: 'pages/charts/gallery.html',
            icon: 'chartgallery.gif',
            desc: 'Demonstrates all of the supported chart types.'
        },{
            text: 'Advanced Charts',
            url: 'pages/charts/advanced.html',
            icon: 'advancedcharts.gif',
            desc: 'Advanced chart features including store and model support.'
        }]
    },{
        title: 'Drag and Drop',
        samples: [{
            text: 'Basic DND',
            url: 'pages/dnd/basicdnd.html',
            icon: 'basicdnd.gif',
            desc: 'A basic DND example not using any specialized drag sources or drop targets.'
        },{
            text: 'List to List',
            url: 'pages/dnd/listtolist.html',
            icon: 'listtolist.gif',
            desc: 'Drag and drop between two lists.'
        },{
            text: 'Grid to Grid',
            url: 'pages/dnd/gridtogrid.html',
            icon: 'gridtogrid.gif',
            desc: 'Drag and drop between two grids supporting both appends and inserts.'
        },{
            text: 'Reordering Grid',
            url: 'pages/dnd/reorderinggrid.html',
            icon: 'gridtogrid.gif',
            desc: 'Reorder the rows within a single grid.'
        },{
            text: 'TreeGrid to TreeGrid',
            url: 'pages/dnd/treegridtotreegrid.html',
            icon: 'treegridtotreegrid.gif',
            desc: 'Drag and drop between two tree grids supporting both appends and inserts.'
        },{
	        text: 'Reordering TreeGrid',
	        url: 'pages/dnd/reorderingtreegrid.html',
            icon: 'treegridtotreegrid.gif',
	        desc: 'Reorder the rows within a single grid.'
        },{
	        text: 'Tree to Tree',
	        url: 'pages/dnd/treetotree.html',
	        icon: 'treetotree.gif',
	        desc: 'Drag and drop between two sorted trees.'
        },{
	        text: 'Reordering Tree',
	        url: 'pages/dnd/reorderingtree.html',
	        icon: 'reorderingtree.gif',
	        desc: 'A single tree where nodes and leafs can be reordered.'
        },{
	        text: 'Image Organizer',
	        url: 'pages/dnd/imageorganizer.html',
	        icon: 'imageorganizer.gif',
	        desc: 'The image organizer shows an example of dragging a picture from a list to a folder in a tree.'
        }]
    },{
        title: 'Windows',
        samples: [{
            text: 'Tree to Tree',
            url: 'pages/window/hello.html',
            icon: 'helloworld.gif',
            desc: 'Simple "Hello World" window that contains a basic TabPanel.'
        },{
            text: 'Accordion Window',
            url: 'pages/window/accordion.html',
            icon: 'accordionwindow.gif',
            desc: 'Window with a nested AccordionLayout.'
        },{
            text: 'MessageBox',
            url: 'pages/window/messagebox.html',
            icon: 'messagebox.gif',
            desc: 'Different styles include confirm, alert, prompt, progress and wait and also support custom icons.'
        },{
            text: 'Dialog',
            url: 'pages/window/dialog.html',
            icon: 'dialog.gif',
            desc: 'Windows with specialized support for buttons.'
        }]
    },{
        title: 'Layout Managers',
        samples: [{
            text: 'Border Layout',
            url: 'pages/layouts/borderlayout.html',
            icon: 'borderlayout.gif',
            desc: 'A complex BorderLayout implementation that shows nesting multiple components and sub-layouts.'
        },{
            text: 'Accordion Layout',
            url: 'pages/layouts/accordionlayout.html',
            icon: 'accordionlayout.gif',
            desc: 'A example of accordioan layout which stacks its chidlren in collapsible panels.'
        },{
            text: 'Anchor Layout',
            url: 'pages/layouts/anchorlayout.html',
            icon: 'anchorlayout.gif',
            desc: 'A simple example of anchoring form fields to a window for flexible form resizing.'
		},{
            text: 'Row Layout',
            url: 'pages/layouts/rowlayout.html',
            icon: 'rowlayout.gif',
            desc: 'Lays out the components in a single row or column, allowing precise control over sizing.'
        },{
            text: 'CardLayout',
            url: 'pages/layouts/cardlayout.html',
            icon: 'cardlayout.gif',
            desc: 'Lays out the components in a stack, with only the top component visible.'
        },{
            text: 'CenterLayout',
            url: 'pages/layouts/centerlayout.html',
            icon: 'centerlayout.gif',
            desc: 'Centers the child component in its container.'
		},{
            text: 'Portal Demo',
            url: 'pages/portal/portal.html',
            icon: 'portal.gif',
            desc: 'A page layout using several custom extensions to provide a web portal interface.'
        },{
            text: 'HBoxLayout',
            url: 'pages/layouts/hboxlayout.html',
            icon: 'hboxlayout.gif',
            desc: 'Extremely flexible layout for aligning components in a single row.'
		},{
            text: 'VBoxLayout',
            url: 'pages/layouts/vboxlayout.html',
            icon: 'vboxlayout.gif',
            desc: 'Extremely flexible layout for aligning components in a single column.'
        }]
    },{
        title: 'ComboBox',
        samples: [{
            text: 'Basic ComboBox',
            url: 'pages/forms/combos.html',
            icon: 'combobox.gif',
            desc: 'Basic combos with auto-complete, type ahead, custom templates.'
        },{
            text: 'ComboBox Templates',
            url: 'pages/forms/forumsearch.html',
            icon: 'forumsearch.gif',
            desc: 'Customized combo with template-based list rendering, remote loading and paging.'
        }]
    },{
        title: 'Forms',
        samples: [{
            text: 'Forms',
            url: 'pages/forms/forms.html',
            icon: 'forms.gif',
            desc: 'Various example forms showing collapsible fieldsets.'
        },{
            text: 'Advanced Forms',
            url: 'pages/forms/advanced.html',
            icon: 'advancedforms.gif',
            desc: 'Advanced form layouts with nested column layout and tab panels.'
        },{
            text: 'DualListField',
            url: 'pages/forms/duallistfield.html',
            icon: 'duallistfield.gif',
            desc: 'A field that displays two list fields and allows selections to be dragged between lists.'
        },{
            text: 'File Upload',
            url: 'pages/forms/fileupload.html',
            icon: 'fileupload.gif',
            desc: 'A field that allows a user to upload a file via a standard HTML submit.'
        }]
    },{
        title: 'Data Binding',
        samples: [{
            text: 'Basic Binding',
            url: 'pages/binding/basicbinding.html',
            icon: 'basicbinding.gif',
            desc: 'Basic binding between model and a form.'
        },{
            text: 'Grid Binding',
            url: 'pages/binding/gridbinding.html',
            icon: 'gridbinding.gif',
            desc: 'Demonstrates an example of binding a model to a form based on the selection of a grid.'
        },{
            text: 'Grid Store Binding',
            url: 'pages/binding/gridstorebinding.html',
            icon: 'gridstorebinding.gif',
            desc: 'Edits are made to the grid are done via the store via records. Edits are cached and can be committed or rejected.'
        }]
    },{
        title: 'Toolbars and Menus',
        samples: [{
            text: 'Basic Toolbar',
            url: 'pages/toolbar/toolbar.html',
            icon: 'basictoolbar.gif',
            desc: 'Toolbar and menus that contain various components like date pickers, sub-menus and more.'
        },{
            text: 'Status Toolbar',
            url: 'pages/toolbar/statustoolbar.html',
            icon: 'statustoolbar.gif',
            desc: 'ToolBar example using new Status component.'   
         },{
            text: 'Advanced Toolbar',
            url: 'pages/toolbar/advancedtoolbar.html',
            icon: 'advancedtoolbar.gif',
            desc: 'Demonstrates "ribbon" style toolbars.'    
         },{
	        text: 'Overflow Toolbar',
	        url: 'pages/toolbar/overflowtoolbar.html',
	        icon: 'overflowtoolbar.gif',
	        desc: 'Toolbars provide overflow support when available width is less than toolbar width.'
         },{
 	        text: 'MenuBar',
 	        url: 'pages/toolbar/menubar.html',
 	        icon: 'menubar.gif',
 	        desc: 'A horizontal application menu bar.' 
        }]
    },{
        title: 'Templates and Lists',
        samples: [{
            text: 'Templates',
            url: 'pages/core/templates.html',
            icon: 'templates.gif',
            desc: 'A simple example of rendering views from templates bound to data objects.'
        },{
            text: 'ListView',
            url: 'view/listview.html',
            icon: 'listview.gif',
            desc: 'A template driven multi-selct list view.'
		},{
            text: 'Advanced ListView',
            url: 'pages/view/chooser.html',
            icon: 'advancedlistview.gif',
            desc: 'A more customized ListView supporting sorting and filtering with multiple templates.'
		},{
            text: 'List',
            url: 'pages/list/datalist.html',
            icon: 'datalist.gif',
            desc: 'Includes both a single and multi select data list.'
        }]
    },{
        title: 'Buttons',
        samples: [{
            text: 'Buttons',
            url: 'pages/button/buttons.html',
            icon: 'buttons.gif',
            desc: 'Various button exmamples including icons, disabled, toggled, and split buttons.'
        },{
            text: 'Button Aligning',
            url: 'pages/button/buttonaligning.html',
            icon: 'buttonaligning.gif',
            desc: 'Demonstrates the varios button alignment options.'
        }]
    },{
        title: 'Miscellaneous',
        samples: [{
            text: 'ToolTips',
            url: 'pages/tips/tooltips.html',
            icon: 'tooltips.gif',
            desc: 'Custom tooltip with title and text.'
		},{
            text: 'DatePicker',
            url: 'pages/misc/datepicker.html',
            icon: 'datepicker.gif',
            desc: 'Component used to select a date.'
        },{
            text: 'Resizable',
            url: 'pages/misc/resizable.html',
            icon: 'resizable.gif',
            desc: 'Example of adding 8-way resizing to a content panel.'
		},{
            text: 'Draggable',
            url: 'pages/misc/draggable.html',
            icon: 'draggable.gif',
            desc: 'Examples of making any element resizable with various configuration options.'
		},{
            text: 'Slider',
            url: 'pages/misc/slider.html',
            icon: 'slider.gif',
            desc: 'Basic demonstration of slider component.'
		},{
            text: 'Custom Slider',
            url: 'pages/misc/customslider.html',
            icon: 'customslider.gif',
            desc: 'Examples of adding custom styling to slider.'
		},{
            text: 'Fx',
            url: 'pages/misc/fx.html',
            icon: 'fx.gif',
            desc: 'Examples of different effects including sliding and moving.'
        }]
    }];
    
	var url = window.location.host;
	var server = url.indexOf('extjs.com') != -1;
	if (!server) {
		catalog.splice(0,1);
	}

    for(var i = 0, c; c = catalog[i]; i++){
        c.id = 'sample-' + i;
    }

    var store = new Ext.data.JsonStore({
        idProperty: 'id',
        fields: ['id', 'title', 'samples'],
        data: catalog
    });

    new Ext.Panel({
        autoHeight: true,
        collapsible: true,
        frame: true,
        title: 'View Samples',
        items: new SamplePanel({
            store: store
        })
    }).render('all-demos');

    var tpl = new Ext.XTemplate(
        '<tpl for="."><li><a href="#{id}">{title:stripTags}</a></li></tpl>'
    );
    tpl.overwrite('sample-menu', catalog);

    Ext.select('#sample-spacer').remove();

});