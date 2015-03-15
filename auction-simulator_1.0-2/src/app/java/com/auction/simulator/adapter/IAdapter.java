/**
 * 
 */
package com.auction.simulator.adapter;

import java.util.List;
import java.util.Map;

import com.auction.simulator.dto.Bidder;
import com.auction.simulator.dto.Product;


/**
 * @author rku140
 *
 */
public interface IAdapter {
	
	
	/**
	 * This is Adapter interface converting Map to List that our Executor class expects
	 * Adapter Design Pattern usage 
	 */
	public List<Product> convertMaptoList(Map<String, List<Bidder>> map);

}
