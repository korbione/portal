package com.dakor.portal.client.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.media.client.Video;
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

    @UiField(provided = true)
    Video videoPlayer;

    public MainPanel() {
        videoPlayer = Video.createIfSupported();
        initWidget(uiBinder.createAndBindUi(this));

        videoPlayer.setSrc("e:\\videoclips\\oceans-clip.mp4");
    }

    public void setWelcomeLabel(String value) {
        welcomeLabel.setText(value);
    }
}