package com.gec.test.gwt.binder.client;

import com.gec.test.gwt.binder.client.panel.ContentPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class UIBinderExample implements EntryPoint
{

    /**
     * This is the entry point method.
     */
    public void onModuleLoad()
    {
        ContentPanel panel = new ContentPanel(new DefaultNameChangeListener(), "GWT User");
        RootPanel.get("content").add(panel);
    }
}
