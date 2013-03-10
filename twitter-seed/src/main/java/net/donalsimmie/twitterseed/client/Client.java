/**
 * Client.java
 *
 * Copyright of Donal Simmie 2013.
 */
package net.donalsimmie.twitterseed.client;

import net.donalsimmie.twitterseed.exception.ServiceException;

import org.junit.runner.Request;

/**
 * 
 * @author Donal Simmie
 * 
 */
public interface Client {

	/**
	 * Perform a GET request and return the result.
	 * 
	 * @param request
	 * @return the response from the get request.
	 * @throws ServiceException
	 *             if there was a problem executing the request
	 */
	Response get(Request request) throws ServiceException;
}
