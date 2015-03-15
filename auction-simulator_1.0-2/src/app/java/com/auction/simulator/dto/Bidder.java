/**
 * 
 */
package com.auction.simulator.dto;

import java.io.Serializable;

/**
 * @author rku140
 *
 */
public class Bidder implements Serializable{
	
	private static final long serialVersionUID = -5761298445315744310L;
	
	public String name;
	public int initialBid;
	public int maxBid;
	public int finalBid;
	public int increment;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInitialBid() {
		return initialBid;
	}
	public void setInitialBid(int initialBid) {
		this.initialBid = initialBid;
	}
	public int getMaxBid() {
		return maxBid;
	}
	public void setMaxBid(int maxBid) {
		this.maxBid = maxBid;
	}
	public int getFinalBid() {
		return finalBid;
	}
	public void setFinalBid(int finalBid) {
		this.finalBid = finalBid;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}

}
