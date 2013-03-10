/**
 * HTTPClientTest.java
 *
 * Copyright of Donal Simmie 2013.
 */
package net.donalsimmie.twitterseed.client.impl;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import net.donalsimmie.twitterseed.client.Client;
import net.donalsimmie.twitterseed.client.JsonResponse;
import net.donalsimmie.twitterseed.client.Request;
import net.donalsimmie.twitterseed.exception.ServiceException;

import org.apache.http.HttpStatus;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

/**
 * 
 * @author Donal Simmie
 * 
 */
public class HTTPClientTest {

	private final Client client = new HTTPClient(new DefaultHttpClient());

	private final String RATE_LIMIT_REQ = "https://api.twitter.com/1/account/rate_limit_status.json";

	/**
	 * Test method for {@link net.donalsimmie.twitterseed.client.impl.HTTPClient#get(org.junit.runner.Request)}.
	 * 
	 * @throws URISyntaxException
	 * @throws ServiceException
	 */
	@Test(expected = IllegalStateException.class)
	public void testBadURI() throws ServiceException, URISyntaxException {
		client.getJson(new Request(new URI("bad_uri")));
	}

	/**
	 * Test method for {@link net.donalsimmie.twitterseed.client.impl.HTTPClient#get(org.junit.runner.Request)}.
	 * 
	 * @throws ServiceException
	 * @throws URISyntaxException
	 */
	public void testGetOk() throws ServiceException, URISyntaxException {
		JsonResponse resp = client.getJson(new Request(new URI(RATE_LIMIT_REQ)));
		assertEquals(resp.getStatusCode(), HttpStatus.SC_OK);
	}

	/**
	 * Test method for {@link net.donalsimmie.twitterseed.client.impl.HTTPClient#get(org.junit.runner.Request)}.
	 * 
	 * @throws ServiceException
	 */
	@Test(expected = NullPointerException.class)
	public void testNullURI() throws ServiceException {
		client.getJson(new Request(null));
	}
}
