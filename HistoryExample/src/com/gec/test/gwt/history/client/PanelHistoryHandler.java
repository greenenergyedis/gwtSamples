package com.gec.test.gwt.history.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 */
public class PanelHistoryHandler implements ValueChangeHandler<String>
{
    private Map<String, Composite> panels = new HashMap<String, Composite>();
    private String defaultPanelKey = "";
    private final RootPanel contentPanel;

    public PanelHistoryHandler(RootPanel contentPanel)
    {
        this.contentPanel = contentPanel;
    }

    public void addPanel(String panelName, Composite panel)
    {
        panels.put(panelName, panel);
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event)
    {
        String historyToken = event.getValue();

        applyPanel(historyToken);

    }

    /**
     * @param defaultPanelKey2
     */
    private void applyPanel(String panelKey)
    {
        if (panelKey == null || "".equals(panelKey))
        {
            applyPanel(panels.get(defaultPanelKey));
        }
        else
        {
            applyPanel(panels.get(panelKey));
        }

    }

    /**
     * @param composite
     */
    private void applyPanel(Composite composite)
    {
        if (composite == null)
        {
            Window.alert("Could not find specified panel");
            return;
        }

        contentPanel.clear();
        contentPanel.add(composite);

    }

    /**
     * @param id
     */
    public void setDefaultPanel(String id)
    {
        defaultPanelKey = id;
    }

}
