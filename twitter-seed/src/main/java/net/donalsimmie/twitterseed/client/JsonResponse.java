/**
 * FriendsResponse.java
 *
 * Copyright of Donal Simmie 2012.
 */
package net.donalsimmie.twitterseed.client;

import java.io.IOException;
import java.io.InputStream;

import net.donalsimmie.twitterseed.exception.ServiceException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * This class is a generic response class for any web service response that returns a single JSON node.
 * 
 * @author Donal Simmie
 * 
 */
public class JsonResponse extends Response {

	/**
	 * The HTTP status code for the response.
	 */
	private final int statusCode;

	/**
	 * Service response represented as JSON object.
	 */
	protected final JsonNode responseData;

	/**
	 * Initialises a new instance of the {@link JsonResponse} class.
	 * 
	 * @param jsonData
	 *            should be a valid JSON string.
	 * @throws JSONException
	 *             if the input string is not valid JSON.
	 * @throws ResponseException
	 */
	public JsonResponse(int statusCode, InputStream jsonStream) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();

		try {
			responseData = mapper.readValue(jsonStream, JsonNode.class);
			this.statusCode = statusCode;
		} catch (JsonProcessingException e) {
			logger.error("Error processing JSON text response from service call.", e);
			throw new ServiceException("Error processing JSON text response from service call.", e);
		} catch (IOException e) {
			logger.error("I/O error parsing JSON string response from service call.", e);
			throw new ServiceException("I/O error parsing JSON string response from service call.", e);
		}
	}

	/**
	 * @return the responseData
	 */
	public JsonNode getResponseData() {
		return responseData;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
}
