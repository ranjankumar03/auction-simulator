/**
 * 
 */
package com.auction.simulator.util;

import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * @author ranjan
 * 
 */
public class SimpleDateFormatter {
	
	private static final Logger log=Logger.getLogger(SimpleDateFormatter.class);

	Date date = null;

	public static Calendar StrintoDate(String time) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, Integer.parseInt(time.split(":")[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt(time.split(":")[1]));
		return cal;
	}
}
