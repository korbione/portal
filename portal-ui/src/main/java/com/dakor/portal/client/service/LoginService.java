package com.dakor.portal.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * .
 *
 * @author Dmitry Korobeynikov
 */
@RemoteServiceRelativePath("portal/loginService")
public interface LoginService extends RemoteService {

    String getDefaultLogin();

}
