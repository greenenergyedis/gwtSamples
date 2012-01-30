package com.gec.test.gwt.binder.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 */
public class NameDialogPanel extends Composite implements HasClickHandlers
{
    private static NameDialogPanelUiBinder uiBinder = GWT.create(NameDialogPanelUiBinder.class);

    interface NameDialogPanelUiBinder extends UiBinder<Widget, NameDialogPanel>
    {}

    private HandlerManager handlerManager;

    @UiField
    Label textToServerLabel;

    @UiField
    HTML serverResponseLabel;

    @UiField
    Button closeButton;

    /**
     * Because this class has a default constructor, it can be used as a binder template. In other
     * words, it can be used in other *.ui.xml files as follows: <ui:UiBinder
     * xmlns:ui="urn:ui:com.google.gwt.uibinder" xmlns:g="urn:import:**user's package**">
     * <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that depending on the
     * widget that is used, it may be necessary to implement HasHTML instead of HasText.
     */
    public NameDialogPanel(String sentValue, String receivedValue)
    {
        initWidget(uiBinder.createAndBindUi(this));
        handlerManager = new HandlerManager(this);
        textToServerLabel.setText(sentValue);
        serverResponseLabel.setHTML(receivedValue);
        closeButton.setFocus(true);
    }

    @UiHandler("closeButton")
    void onClick(ClickEvent e)
    {
        handlerManager.fireEvent(e);
    }

    /**
     * @see com.google.gwt.event.dom.client.HasClickHandlers#addClickHandler(com.google.gwt.event.dom.client.ClickHandler)
     */
    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler)
    {
        return handlerManager.addHandler(ClickEvent.getType(), handler);
    }
}
