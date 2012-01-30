package com.gec.test.gwt.history.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Panel1 extends Composite
{
    private static Panel1UiBinder uiBinder = GWT.create(Panel1UiBinder.class);

    interface Panel1UiBinder extends UiBinder<Widget, Panel1>
    {}

    public static final String ID = "panel1";

    @UiField
    Button nextButton;

    public Panel1()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("nextButton")
    public void nextButtonClicked(ClickEvent e)
    {
        History.newItem(Panel2.ID);
    }
}
