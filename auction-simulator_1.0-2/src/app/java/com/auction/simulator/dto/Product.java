/**
 * 
 */
package com.auction.simulator.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author rku140
 *
 */
public class Product implements Serializable , IAuctionProductType{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3462521832187116368L;
	
	private String productName;
	private String productDesc;
	private List<Bidder> bidders;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public List<Bidder> getBidders() {
		return bidders;
	}
	public void setBidders(List<Bidder> bidders) {
		this.bidders = bidders;
	}
	
	

}
