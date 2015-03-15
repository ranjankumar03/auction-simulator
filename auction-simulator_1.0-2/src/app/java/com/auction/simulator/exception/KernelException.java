/**
 * 
 */
package com.auction.simulator.exception;

/**
 * @author ranjan
 * 
 */

// Root of all Exception defined in the application and so must be
// extended by all other Custom Exception
public class KernelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KernelException() {
		// TODO Auto-generated constructor stub
		super();
	}

	public KernelException(String argMessage) {
		super(argMessage);
	}

}
