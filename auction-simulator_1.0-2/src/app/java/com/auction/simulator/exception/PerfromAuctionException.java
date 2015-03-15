/**
 * 
 */
package com.auction.simulator.exception;

/**
 * @author ranjan
 * 
 */
public class PerfromAuctionException extends KernelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object objectInIssue;

	public PerfromAuctionException() {
		// TODO Auto-generated constructor stub
		super();
	}

	public PerfromAuctionException(String argMessage) {
		super(argMessage);
	}

	public PerfromAuctionException(String argMessage, Object objectInIssue) {
		super(argMessage);
		this.objectInIssue = objectInIssue;
	}

	@Override
	public String toString() {
		return "PerfromException [objectInIssue=" + objectInIssue + "]";
	}

}
