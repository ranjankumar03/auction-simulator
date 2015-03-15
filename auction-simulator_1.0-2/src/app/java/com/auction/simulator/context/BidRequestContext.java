/**
 * 
 */
package com.auction.simulator.context;

import java.io.File;

import org.apache.log4j.Logger;


/**
 * @author rku140
 *
 */
public class BidRequestContext extends Context{
	
	private static final Logger log = Logger.getLogger(BidRequestContext.class);
	
	private File bidRequestFile ;

	public File getBidRequestFile() {
		return bidRequestFile;
	}

	public void setBidRequestFile(File bidRequestFile) {
		this.bidRequestFile = bidRequestFile;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
