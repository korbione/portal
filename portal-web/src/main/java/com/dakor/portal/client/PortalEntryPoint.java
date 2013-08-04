package com.dakor.portal.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 *
 *
 * @author Dmitry Korobeynikov
 */
public class PortalEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel.get("slot1").add(new MainPanel());
    }
}
