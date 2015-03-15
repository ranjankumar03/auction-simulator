/**
 * 
 */
package com.auction.simulator.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.auction.simulator.dto.Bidder;
import com.auction.simulator.dto.Product;

/**
 * @author rku140
 *
 */
public class MapToListAdapter implements IAdapter {

	private static final Logger log = Logger.getLogger(MapToListAdapter.class);

	List<Product> list = null;
	
	/**Constructor*/
	public MapToListAdapter(){
		list = new ArrayList<Product>();
	}

	public List<Product> convertMaptoList(Map<String, List<Bidder>> cache) {

		log.info("Inside Adapter to Convert Map to List Type");
		
		System.out.println("Cache Sizess" + cache.size());
		for (String key : cache.keySet()) {
			List<Bidder> bidderList = (List<Bidder>) cache.get(key);
			Product product = new Product();
			product.setProductName(key);
			product.setProductDesc(key + "Desc");
			product.setBidders(bidderList);
			list.add(product);
		}
		return list;
	}

}
