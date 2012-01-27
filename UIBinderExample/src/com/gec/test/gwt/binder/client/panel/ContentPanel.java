package com.gec.test.gwt.binder.client.panel;

import com.gec.test.gwt.binder.client.NameChangeListener;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ContentPanel extends Composite implements HasText
{
    private static ContentPanelUiBinder uiBinder = GWT.create(ContentPanelUiBinder.class);

    interface ContentPanelUiBinder extends UiBinder<Widget, ContentPanel>
    {}

    private NameChangeListener nameChangeListener;

    @UiField
    Button sendButton;

    @UiField
    TextBox nameField;

    public ContentPanel(NameChangeListener nameChangeListener, String name)
    {
        initWidget(uiBinder.createAndBindUi(this));
        this.nameChangeListener = nameChangeListener;
        nameField.setText(name);
    }

    @UiHandler("sendButton")
    void onClick(ClickEvent e)
    {
        nameChangeListener.nameChanged(nameField.getText());
    }

    @UiHandler("nameField")
    void keyPressed(KeyUpEvent e)
    {
        if (e.getNativeKeyCode() == KeyCodes.KEY_ENTER)
        {
            nameChangeListener.nameChanged(nameField.getText());
        }
    }

    public void setText(String text)
    {
        nameField.setText(text);
    }

    /**
     * Gets invoked when the default constructor is called and a string is provided in the ui.xml
     * file.
     */
    public String getText()
    {
        return nameField.getText();
    }
}
