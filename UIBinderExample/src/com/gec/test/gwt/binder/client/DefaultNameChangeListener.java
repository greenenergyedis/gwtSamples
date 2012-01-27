package com.gec.test.gwt.binder.client;

import com.gec.test.gwt.binder.client.panel.NameDialogPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;

/**
 * 
 */
public class DefaultNameChangeListener implements NameChangeListener
{
    private GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    @Override
    public void nameChanged(final String name)
    {
        greetingService.greetServer(name, new AsyncCallback<String>()
        {

            @Override
            public void onSuccess(String result)
            {
                NameDialogPanel namePanel = new NameDialogPanel(name, result);
                final DialogBox box = new DialogBox();
                box.setText("RPC call");
                box.setAnimationEnabled(true);
                box.setWidget(namePanel);
                namePanel.addClickHandler(new ClickHandler()
                {
                    @Override
                    public void onClick(ClickEvent event)
                    {
                        box.hide();
                    }
                });
                box.center();
            }

            @Override
            public void onFailure(Throwable caught)
            {}
        });
    }
}
