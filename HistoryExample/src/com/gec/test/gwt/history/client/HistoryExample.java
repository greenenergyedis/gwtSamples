package com.gec.test.gwt.history.client;

import com.gec.test.gwt.history.client.panel.Panel1;
import com.gec.test.gwt.history.client.panel.Panel2;
import com.gec.test.gwt.history.client.panel.Panel3;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HistoryExample implements EntryPoint
{

    public void onModuleLoad()
    {
        Panel1 panel1 = new Panel1();
        Panel2 panel2 = new Panel2();
        Panel3 panel3 = new Panel3();

        PanelHistoryHandler historyHandler = new PanelHistoryHandler(RootPanel.get("content"));
        historyHandler.addPanel(Panel1.ID, panel1);
        historyHandler.addPanel(Panel2.ID, panel2);
        historyHandler.addPanel(Panel3.ID, panel3);
        historyHandler.setDefaultPanel(Panel1.ID);

        History.addValueChangeHandler(historyHandler);
        History.fireCurrentHistoryState();

    }
}
