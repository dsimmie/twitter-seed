/**
 * Response.java
 *
 * Copyright of Donal Simmie 2013.
 */
package net.donalsimmie.twitterseed.client;

import net.donalsimmie.twitterseed.Config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author Donal Simmie
 * 
 */
public abstract class Response {

	/**
	 * The class logger.
	 */
	protected final Logger logger = Logger.getLogger(Response.class.getName());

	/**
	 * Initialises a new instance of the {@link Response} class.
	 * 
	 * @param response
	 */
	protected Response() {
		PropertyConfigurator.configure(Config.LOG_FILE_PATH);
	}
}
