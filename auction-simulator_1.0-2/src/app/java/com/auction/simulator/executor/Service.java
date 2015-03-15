package com.auction.simulator.executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import com.auction.simulator.dto.Bidder;


/**
 * @author rku140
 * Parallel execution of Bidders for each Product
 */
public class Service implements Callable<Bidder> {
	
	public Bidder bid;
	Service(Bidder bid){
		this.bid = bid;
	}
	
	Map<String,Integer>  finalBidValues1 = new HashMap<String,Integer>();
	List<Integer> finalBidValues = new ArrayList<Integer>();
	

	//Keep all Bidders max value offered for the product till Expiry time
	
	
	public Bidder call() {
		//  System.out.println("Run.................");
		// TODO Auto-generated method stub
		int maxValue = bid.getInitialBid();
		System.out.println("Initial Value::"+maxValue);
		System.out.println("Max Value::"+bid.getMaxBid());
		while (maxValue < (bid.getMaxBid()-bid.getIncrement())){
			maxValue += bid.getIncrement();
			System.out.println("Bidder "+ bid.getName() +" "+ "intermediate maxValues:"+ maxValue);
		}
		//System.out.println("Final Value------------------------>"+ maxValue);
		bid.setFinalBid(maxValue);
		return bid;
	}

	
	

}
