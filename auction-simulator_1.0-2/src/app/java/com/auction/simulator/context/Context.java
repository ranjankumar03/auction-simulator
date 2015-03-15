/**
 * 
 */
package com.auction.simulator.context;

import org.apache.log4j.Logger;


/**
 * @author ranjan
 *
 */
//Root Context to pass and central to all objects;can beb used to pass common parametsr across applications classes
public class Context {
	
	private static final Logger log = Logger.getLogger(Context.class);
	
	private boolean status =  false;
	private int processId;
	private String processDesc;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
	
	
	public String getProcessDesc() {
		return processDesc;
	}
	public void setProcessDesc(String processDesc) {
		this.processDesc = processDesc;
	}
	@Override
	public String toString() {
		return "CabContext [status=" + status + ", processId=" + processId
				+ "]";
	}

}
