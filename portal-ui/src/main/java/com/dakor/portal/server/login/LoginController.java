package com.dakor.portal.server.login;

import com.dakor.portal.client.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author Dmitry Korobeynikov
 */
@Service("loginService")
public class LoginController implements LoginService {

    @Override
    public String getDefaultLogin() {
        return "korbione";
    }

}