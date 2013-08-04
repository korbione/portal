package com.dakor.portal.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 */
public class MainPanel extends Widget {
    interface MainPanelUiBinder extends UiBinder<HTMLPanel, MainPanel> {
    }

    private static MainPanelUiBinder ourUiBinder = GWT.create(MainPanelUiBinder.class);

    public MainPanel() {
        ourUiBinder.createAndBindUi(this);

    }
}