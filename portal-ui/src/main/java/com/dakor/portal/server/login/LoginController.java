package com.dakor.portal.server.login;

import com.dakor.portal.client.service.LoginService;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;

/**
 * .
 *
 * @author Dmitry Korobeynikov
 */
@Service("loginService")
public class LoginController implements LoginService {

    @Override
    public String getDefaultLogin() {
		try {
			Closeable httpServer = com.dakor.portal.rest.App.startServer();
			System.out.println(String.format("Jersey app started with WADL available at "
					+ "%sapplication.wadl\nTry out %shelloworld\nHit enter to stop it...",
					com.dakor.portal.rest.App.BASE_URI, com.dakor.portal.rest.App.BASE_URI));
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
        return "korbione";
    }

}