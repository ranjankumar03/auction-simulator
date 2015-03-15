/**
 * 
 */
package com.auction.simulator.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.auction.simulator.constant.AuctionSimulatoConstants;
import com.auction.simulator.context.BidRequestContext;
import com.auction.simulator.dto.Bidder;
import com.auction.simulator.dto.Product;

/**
 * @author rku140
 *
 */

public class AuctionSimulatorCacheManagerImpl implements ICache {

	private static final Logger log = Logger
			.getLogger(AuctionSimulatorCacheManagerImpl.class);

	List<Product> productList=null;
	List<Bidder> bidderListProd1=null;
	List<Bidder> bidderListProd2=null;
	List<Bidder> bidderListProd3=null;
	Map<String, List<Bidder>> cache=null;
	
	/**Constructor*/
	public AuctionSimulatorCacheManagerImpl(){
		productList = new ArrayList<Product>();
		bidderListProd1 = new ArrayList<Bidder>();
		bidderListProd2 = new ArrayList<Bidder>();
		bidderListProd3 = new ArrayList<Bidder>();
		cache = new HashMap<String, List<Bidder>>();
	}
	

	/**
	 * List<Product> return type
	 */
	public Map<String, List<Bidder>> buildCache(BidRequestContext context) {

		//TODO : Implement Strategy Design Pattern to load bidder Info from txt,xml,database sources
		log.info("Cache building ...............");
		// Begins Map Imp
		

		BufferedReader br = null;
		String line;
		File request = context.getBidRequestFile();
		try {
			br = new BufferedReader(new FileReader(request));
			br.readLine();//Skip for first Date header row
			br.readLine();//skip for main header row
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, AuctionSimulatoConstants.DELIMITER);
				while (st.hasMoreElements()) {
					String productName = st.nextToken().toString();
					if (productName.equalsIgnoreCase(AuctionSimulatoConstants.BICYCLE)) {
						Bidder bidder = new Bidder();
						bidder.setName(st.nextToken());
						bidder.setInitialBid(Integer.parseInt(st.nextToken()));
						bidder.setMaxBid(Integer.parseInt(st.nextToken()));
						bidder.setIncrement(Integer.parseInt(st.nextToken()));
						bidderListProd1.add(bidder);

					} else if (productName.equalsIgnoreCase(AuctionSimulatoConstants.SCOOTER)) {
						Bidder bidder = new Bidder();
						bidder.setName(st.nextToken());
						bidder.setInitialBid(Integer.parseInt(st.nextToken()));
						bidder.setMaxBid(Integer.parseInt(st.nextToken()));
						bidder.setIncrement(Integer.parseInt(st.nextToken()));
						bidderListProd2.add(bidder);

					} else if (productName.equalsIgnoreCase(AuctionSimulatoConstants.BOAT)) {
						Bidder bidder = new Bidder();
						bidder.setName(st.nextToken());
						bidder.setInitialBid(Integer.parseInt(st.nextToken()));
						bidder.setMaxBid(Integer.parseInt(st.nextToken()));
						bidder.setIncrement(Integer.parseInt(st.nextToken()));
						bidderListProd3.add(bidder);

					}

				}

			}

			cache.put("Bicycle", bidderListProd1);
			cache.put("Scooter", bidderListProd2);
			cache.put("Boat", bidderListProd3);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();

			}

		}

		
		return cache;
	}

}
