/**
 * HTTPClient.java
 *
 * Copyright of Donal Simmie 2013.
 */
package net.donalsimmie.twitterseed.client.impl;

import net.donalsimmie.twitterseed.client.Client;
import net.donalsimmie.twitterseed.client.Response;
import net.donalsimmie.twitterseed.exception.ServiceException;

import org.junit.runner.Request;

/**
 * 
 * @author Donal Simmie
 * 
 */
public class HTTPClient implements Client {

	/**
	 * Initialises a new instance of the {@link HTTPClient} class.
	 * 
	 */
	public HTTPClient() {
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws ServiceException
	 * @see net.donalsimmie.twitterseed.client.Client#get(org.junit.runner.Request)
	 */
	@Override
	public Response get(Request request) throws ServiceException {
		return null;
	}

}
