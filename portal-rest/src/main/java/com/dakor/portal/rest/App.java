package com.dakor.portal.rest;

import com.sun.jersey.api.container.filter.LoggingFilter;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.simple.container.SimpleServerFactory;

import javax.ws.rs.core.UriBuilder;
import java.io.Closeable;
import java.io.IOException;
import java.net.URI;

/**
 * @author dkor
 */
public class App {

	private static int getPort(int defaultPort) {
		String port = System.getProperty("jersey.test.port");
		if (null != port) {
			try {
				return Integer.parseInt(port);
			} catch (NumberFormatException e) {
			}
		}
		return defaultPort;
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost/").port(getPort(9998)).build();
	}

	public static final URI BASE_URI = getBaseURI();

	public static Closeable startServer() throws IOException {
		System.out.println("Starting simple...");
		ResourceConfig rc = new DefaultResourceConfig();
		rc.getSingletons().add(new MediaResource());
		rc.getFeatures().put(LoggingFilter.FEATURE_LOGGING_DISABLE_ENTITY, true);
		rc.getProperties().put(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS, LoggingFilter.class.getName());
		rc.getProperties().put(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, LoggingFilter.class.getName());

		return SimpleServerFactory.create(BASE_URI, rc);
	}

}
