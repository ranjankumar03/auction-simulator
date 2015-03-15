package com.auction.simulator.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.auction.simulator.dto.Bidder;
import com.auction.simulator.dto.Product;

public class Sample {

	@After
	public void tearDown() throws Exception {
	}
	
    Bidder firstBidder = null;
    List<Bidder> firstbidList = new ArrayList<Bidder>();
    List<Bidder> secondbidList = new ArrayList<Bidder>();
    List<Product> productList = new ArrayList<Product>();
	
	@Before
	public void initializeBidObject(){
		firstBidder.setName("Alice");
		firstBidder.setInitialBid(50);
		firstBidder.setFinalBid(80);
		firstBidder.setIncrement(3);
		firstbidList.add(firstBidder);
		Product prod = new Product();
		prod.setProductName("Bicylce");
		
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
		
	}

}
