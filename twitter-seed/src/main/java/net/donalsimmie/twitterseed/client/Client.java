/**
 * Client.java
 *
 * Copyright of Donal Simmie 2013.
 */
package net.donalsimmie.twitterseed.client;

import net.donalsimmie.twitterseed.exception.ServiceException;

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
	 * @return the JSON response from the get request.
	 * @throws ServiceException
	 *             if there was a problem executing the request
	 */
	JsonResponse getJson(Request request) throws ServiceException;
}
