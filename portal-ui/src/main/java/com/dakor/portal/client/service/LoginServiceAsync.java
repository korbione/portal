package com.dakor.portal.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * .
 *
 * @author Dmitry Korobeynikov
 */
public interface LoginServiceAsync {

    void getDefaultLogin(AsyncCallback<String> callback);

}
