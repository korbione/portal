package com.dakor.portal.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

/**
 *
 */
public class MainPanel extends Composite {
    interface MainPanelUiBinder extends UiBinder<HTMLPanel, MainPanel> {
    }

    private static MainPanelUiBinder uiBinder = GWT.create(MainPanelUiBinder.class);

    @UiField
    Label welcomeLabel;

    public MainPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setWelcomeLabel(String value) {
        welcomeLabel.setText(value);
    }
}