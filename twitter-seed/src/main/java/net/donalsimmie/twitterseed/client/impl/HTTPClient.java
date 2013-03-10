/**
 * HTTPClient.java
 *
 * Copyright of Donal Simmie 2013.
 */
package net.donalsimmie.twitterseed.client.impl;

import java.io.IOException;
import java.io.InputStream;

import net.donalsimmie.twitterseed.Config;
import net.donalsimmie.twitterseed.client.Client;
import net.donalsimmie.twitterseed.client.JsonResponse;
import net.donalsimmie.twitterseed.client.Request;
import net.donalsimmie.twitterseed.exception.ServiceException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author Donal Simmie TODO change name to suitable to avoid confusion with {@link HttpClient}
 */
public class HTTPClient implements Client {

	/**
	 * The HTTP client that handles HTTP interactions with the server.
	 */
	private final HttpClient client;

	/**
	 * The class logger.
	 */
	protected final Logger logger = Logger.getLogger(HTTPClient.class.getName());

	/**
	 * Initialises a new instance of the {@link HTTPClient} class.
	 * 
	 */
	public HTTPClient(HttpClient client) {
		this.client = client;
		PropertyConfigurator.configure(Config.LOG_FILE_PATH);
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws ServiceException
	 * @see net.donalsimmie.twitterseed.client.Client#get(org.junit.runner.Request)
	 */
	@Override
	public JsonResponse getJson(Request request) throws ServiceException {
		HttpGet profileRequest = new HttpGet(request.getUri());

		HttpResponse response = null;
		InputStream instream = null;
		HttpEntity entity = null;
		JsonResponse responseData = null;
		try {
			response = client.execute(profileRequest);

			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode == request.getConfirmationCode()) {
				entity = response.getEntity();
				instream = entity.getContent();

				responseData = new JsonResponse(statusCode, instream);
			} else {
				logger.error("Error retrieving observations data. HTTP error code: " + statusCode);
				profileRequest.abort();
			}
		} catch (IOException e) {
			profileRequest.abort();
			throw new ServiceException("Error performing HTTP GET request", e);
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				throw new ServiceException("Error closing input stream", e);
			}
		}
		return responseData;
	}
}
