package com.auction.simulator.executor;

import java.util.List;

import com.auction.simulator.dto.Product;

public interface IBidExecutorAlgo {
	
	public void executeAlgo(List<Product> list);

}
