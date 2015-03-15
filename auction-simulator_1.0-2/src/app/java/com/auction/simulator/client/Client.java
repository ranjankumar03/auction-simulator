/**
 * 
 */
package com.auction.simulator.client;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.auction.simulator.constant.AuctionSimulatoConstants;
import com.auction.simulator.context.BidRequestContext;
import com.auction.simulator.controller.AuctionSimulatorControllerImpl;
import com.auction.simulator.controller.IController;
import com.auction.simulator.exception.PerfromAuctionException;


/**
 * @author rku140
 *
 */
public class Client {
	
    private static final Logger log = Logger.getLogger(Client.class);
    
    //TODO : Keep this path in property file or fetch from database on runtime
	private static String bidRequestFile = 
			"C:\\Users\\rku140\\workspace\\auction-simulator_1.0-2\\bidRequest.txt";
	static IController controller = null;
	static BidRequestContext context=null;
	

	/**
	 * This is the client code that make
	 * @throws PerfromAuctionException 
	 */
	public static void main(String[] args) throws PerfromAuctionException {
		
		context = new BidRequestContext();
		context.setProcessId(1);
		context.setProcessDesc(AuctionSimulatoConstants.AUCTION_PROCESS);//Usage of Constant
		context.setStatus(true);
		context.setBidRequestFile(new File(bidRequestFile));
		
		try {
			controller = new AuctionSimulatorControllerImpl();
			log.info("Calling Controller to control the auction process..");
			System.out.println("Calling Controller to control the auction process..");
			controller.triggetAuctionSimulator(context);
			
		} catch (Exception e) {
		    throw new PerfromAuctionException("Exception while perofrming Auction ......"+e);
		}
		finally{
			log.info("Client program exiting.................");
			System.out.println("Client program exiting.................");
			System.exit(0);
		}

	}

}
