package com.dakor.portal.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * .
 *
 * @author Dmitry Korobeynikov
 */
public class MenuView extends Composite implements IMenuView {
    interface MenuViewUiBinder extends UiBinder<HTMLPanel, MenuView> {
    }

    private static MenuViewUiBinder uiBinder = GWT.create(MenuViewUiBinder.class);

    MenuView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
