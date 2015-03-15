/**
 * 
 */
package com.auction.simulator.executor;

import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.auction.simulator.constant.AuctionSimulatoConstants;
import com.auction.simulator.dto.Bidder;
import com.auction.simulator.dto.Product;

/**
 * @author rku140
 *
 */
public class Algorithm {

	private static final Logger log = Logger.getLogger(Algorithm.class);

	TreeSet<Integer> biddersSet = new TreeSet<Integer>();

	public void execute(Product prod) throws InterruptedException,
			ExecutionException {

		//maxSearch Algorithm Used to fetch maximum bidding value of bidder for eeach product
		Integer maxBidValue = Integer.MIN_VALUE;
		String maxBidderName = null;
		System.out.println("Prouct Algo----------------------"
				+ prod.getProductName());
		ScheduledExecutorService exec = Executors
				.newScheduledThreadPool(Runtime.getRuntime()
						.availableProcessors() + 1);

		for (Bidder bid : prod.getBidders()) {

			ScheduledFuture<Bidder> maxvalue1 = exec.schedule(new Service(bid),
					AuctionSimulatoConstants.ONE, TimeUnit.MILLISECONDS);

			if ((maxvalue1.get()).getFinalBid() > maxBidValue) {
				maxBidValue = (maxvalue1.get()).getFinalBid();
				//DEBUG: System.out.println("Intermediate Max value::"+ maxBidValue);
				maxBidderName = (maxvalue1.get()).getName();
				//DEBUG: System.out.println("Intermediate bidderName::"+
				// maxBidderName);

			}
			try {
				biddersSet.add((maxvalue1.get()).getFinalBid());
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (ExecutionException e) {
				
				e.printStackTrace();
			}

		}
		
		
		/**
		 * Final Winner Details print here
		 *
		 */

		System.out
				.println("================================================================================");
		System.out.println("Product <" + prod.getProductName() + ">" + "=="
				+ "Bidder Name <" + maxBidderName + ">" + "==" + "Value <"
				+ maxBidValue + ">" + "==" + "IS WINNER");
		System.out
				.println("================================================================================");
	}

}
