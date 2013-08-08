package com.dakor.portal.client.login;

import com.dakor.portal.model.LoginModel;
import com.google.gwt.core.client.Callback;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * .
 *
 * @author Dmitry Korobeynikov
 */
public interface ILoginView extends IsWidget {

    void addLoginHander(Callback<LoginModel, String> loginCallback);

}
