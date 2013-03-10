/**
 * Response.java
 *
 * Copyright of Donal Simmie 2013.
 */
package net.donalsimmie.twitterseed.client;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URI;

import org.apache.http.HttpStatus;

/**
 * 
 * @author Donal Simmie
 * 
 */
public class Request {

	/**
	 * The HTTP status code for a successful response.
	 */
	private final int confirmationCode;

	/**
	 * The unique identifier for this request.
	 */
	private final URI uri;

	/**
	 * Initialises a new instance of the {@link Request} class.
	 * 
	 * @param confirmationCode
	 * @param uri
	 */
	public Request(int confirmationCode, URI uri) {
		super();
		checkNotNull(uri);
		this.confirmationCode = confirmationCode;
		this.uri = uri;
	}

	/**
	 * Initialises a new instance of the {@link Request} class.
	 * 
	 * @param uri
	 */
	public Request(URI uri) {
		this(HttpStatus.SC_OK, uri);
	}

	/**
	 * 
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (confirmationCode != other.confirmationCode)
			return false;
		return true;
	}

	/**
	 * @return the confirmationCode
	 */
	public int getConfirmationCode() {
		return confirmationCode;
	}

	/**
	 * @return the uri
	 */
	public URI getUri() {
		return uri;
	}

	/**
	 * 
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + confirmationCode;
		return result;
	}

	/**
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Request [confirmationCode=");
		builder.append(confirmationCode);
		builder.append("]");
		return builder.toString();
	}

}
