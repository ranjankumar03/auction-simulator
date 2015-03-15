/**
 * 
 */
package com.auction.simulator.executor;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;

import com.auction.simulator.dto.Product;

/**
 * @author rku140 CountDownLatch use for parallel execution of Different Product
 *         Bidding
 */
public class BidExecutorAlgoImpl implements IBidExecutorAlgo {

	private static final Logger log = Logger
			.getLogger(BidExecutorAlgoImpl.class);

	public void executeAlgo(List<Product> productList) {

		log.info("Main Algorithms begins.....");

		System.out.println("Size of Product List _------->"
				+ productList.size());

		final CountDownLatch latch = new CountDownLatch(productList.size());

		for (Product prod : productList) {

			System.out.println("Product Deatails :::" + prod.toString());

			Thread prodExec = new Thread(
					new ProductExceution(prod, 1000, latch));
			prodExec.start();

		}

		try {
			latch.await();
			System.out
					.println("All there Product Algo kicked off paraellely::::::::::::::::");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class ProductExceution implements Runnable {

	private final Product prod;
	private final int time;
	private final CountDownLatch latch;

	public ProductExceution(Product prod, int timeToStart, CountDownLatch latch) {
		// TODO Auto-generated constructor stub

		this.prod = prod;
		this.time = timeToStart;
		this.latch = latch;
	}

	@Override
	public void run() {

		System.out.println("Product Name Executoion Begins------------>"
				+ prod.getProductName());
		Algorithm algo = new Algorithm();
		try {
			algo.execute(prod);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Product Name Executoion Ends------------>"
				+ prod.getProductName());

		latch.countDown();

	}

}
