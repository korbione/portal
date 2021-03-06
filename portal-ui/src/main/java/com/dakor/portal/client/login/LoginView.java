package com.dakor.portal.client.login;

import com.dakor.portal.client.service.LoginService;
import com.dakor.portal.client.service.LoginServiceAsync;
import com.dakor.portal.model.LoginModel;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * .
 *
 * @author Dmitry Korobeynikov
 */
public class LoginView extends Composite implements ILoginView {

    interface LoginViewUiBinder extends UiBinder<HTMLPanel, LoginView> {
    }

    private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);

    @UiField
    TextBox userNameTextBox;

    @UiField
    PasswordTextBox passwordTextBox;

    private LoginServiceAsync loginController = GWT.create(LoginService.class);

    private Callback<LoginModel, String> loginCallback;

    LoginView() {
        initWidget(uiBinder.createAndBindUi(this));

        loginController.getDefaultLogin(new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                throw new RuntimeException(throwable);
            }

            @Override
            public void onSuccess(String login) {
                userNameTextBox.setValue(login);
            }
        });
    }

    @UiHandler("loginButton")
    @SuppressWarnings("unused")
    void loginButtonHandler(ClickEvent clickEvent) {
        if (loginCallback != null) {
            LoginModel loginModel = new LoginModel();
            loginModel.setName(userNameTextBox.getValue());
            loginModel.setPassword(passwordTextBox.getValue());

            loginCallback.onSuccess(loginModel);
        }
    }

    @Override
    public void addLoginHander(Callback<LoginModel, String> loginCallback) {
        this.loginCallback = loginCallback;
    }

}
