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

/**
 * 
 */
public class Panel2 extends Composite
{
    private static Panel2UiBinder uiBinder = GWT.create(Panel2UiBinder.class);

    interface Panel2UiBinder extends UiBinder<Widget, Panel2>
    {}

    public static final String ID = "panel2";

    @UiField
    Button nextButton;

    @UiField
    Button prevButton;

    public Panel2()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("nextButton")
    public void goNext(ClickEvent e)
    {
        History.newItem(Panel3.ID);
    }

    @UiHandler("prevButton")
    public void goBack(ClickEvent e)
    {
        History.back();
    }

}
