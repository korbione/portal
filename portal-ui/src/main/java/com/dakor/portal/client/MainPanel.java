package com.dakor.portal.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 *
 */
public class MainPanel extends Composite {
    interface MainPanelUiBinder extends UiBinder<HTMLPanel, MainPanel> {
    }

    private static MainPanelUiBinder ourUiBinder = GWT.create(MainPanelUiBinder.class);

    public MainPanel() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}