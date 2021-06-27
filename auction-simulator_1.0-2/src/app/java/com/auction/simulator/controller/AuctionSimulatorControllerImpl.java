/**
 * 
 */
package com.auction.simulator.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.auction.simulator.adapter.IAdapter;
import com.auction.simulator.adapter.MapToListAdapter;
import com.auction.simulator.cache.AuctionSimulatorCacheManagerImpl;
import com.auction.simulator.cache.ICache;
import com.auction.simulator.context.BidRequestContext;
import com.auction.simulator.dto.Bidder;
import com.auction.simulator.dto.Product;
import com.auction.simulator.executor.BidExecutorAlgoImpl;
import com.auction.simulator.executor.IBidExecutorAlgo;

/**
 * @author rku140 Main Controller class to control the entire auction process
 */

public class AuctionSimulatorControllerImpl implements IController {

	private static final Logger log = Logger
			.getLogger(AuctionSimulatorControllerImpl.class);

	ICache cache = null;
	List<Product> list = null;
	IBidExecutorAlgo executor = null;
	IAdapter adapter = null;
	
	/**Constructor*/
	public AuctionSimulatorControllerImpl() {

		cache = new AuctionSimulatorCacheManagerImpl();
		adapter = new MapToListAdapter();
		executor = new BidExecutorAlgoImpl();
	}

	/**
	 * trigger controller
	 *
	 */
	@Override
	public void triggetAuctionSimulator(BidRequestContext context) {
		
		log.info("Inside Controller....");
		// load cache
		
		Map<String, List<Bidder>> cache1 = cache.buildCache(context);

		// Calling adapter to convert the paramets into desired format that
		// Executor class expecting
		
		list = adapter.convertMaptoList(cache1);

		// call executor that calls auction algo
		
		executor.executeAlgo(list);

	}

}
