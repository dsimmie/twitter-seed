/**
 * ServiceException.java
 *
 * Copyright of Donal Simmie 2013.
 */
package net.donalsimmie.twitterseed.exception;

/**
 * 
 * @author Donal Simmie
 * 
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Initialises a new instance of the {@link ServiceException} class.
	 * 
	 */
	public ServiceException() {
	}

	/**
	 * Initialises a new instance of the {@link ServiceException} class.
	 * 
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Initialises a new instance of the {@link ServiceException} class.
	 * 
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Initialises a new instance of the {@link ServiceException} class.
	 * 
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}

}
