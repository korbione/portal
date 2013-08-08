package com.dakor.portal.client;

import com.dakor.portal.client.login.ILoginView;
import com.dakor.portal.client.login.LoginView;
import com.dakor.portal.model.LoginModel;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 *
 *
 * @author Dmitry Korobeynikov
 */
public class PortalEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {

        ILoginView loginView = GWT.create(LoginView.class);
        RootPanel.get().add(loginView);
        loginView.addLoginHander(new Callback<LoginModel, String>() {
            @Override
            public void onFailure(String s) {
                throw new RuntimeException(s);
            }

            @Override
            public void onSuccess(LoginModel loginModel) {
                RootPanel.get().clear();
                MainPanel mainView = GWT.create(MainPanel.class);
                mainView.setWelcomeLabel("Welcome to portal, " + loginModel.getName());
                RootPanel.get().add(mainView);
            }
        });
    }
}
