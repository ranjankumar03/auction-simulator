/**
 * 
 */
package com.auction.simulator.cache;

import java.util.List;
import java.util.Map;

import com.auction.simulator.context.BidRequestContext;
import com.auction.simulator.dto.Bidder;

/**
 * @author rku140
 *
 */
public interface ICache {
	
	public Map<String,List<Bidder>> buildCache(BidRequestContext context);

}
