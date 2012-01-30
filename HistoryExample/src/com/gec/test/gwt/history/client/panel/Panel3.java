package com.gec.test.gwt.history.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Panel3 extends Composite
{
    private static Panel3UiBinder uiBinder = GWT.create(Panel3UiBinder.class);

    interface Panel3UiBinder extends UiBinder<Widget, Panel3>
    {}

    public static final String ID = "panel3";

    public Panel3()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
