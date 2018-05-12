package org.meteorology.swat.ncdc.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that interacts with NOAA portal to fetch the 
 * severe weather (hail, flood, thunderstorm, tornado) reports in CSV format.
 * @author Krishnan Subramanian
 */
public final class NCDCParse {

	private static final Logger logger = LoggerFactory.getLogger(NCDCParse.class);
	
	private static final String BASE_URL = "https://www.ncdc.noaa.gov/stormevents/csv?";

	/**
	 * Call the NCDC URL and get the severe weather report.
	 * @param state the state to get the reports for.
	 * @param startAndEndDates The start and end dates for the 
	 * @return A {@link BufferedReader} object.
	 * Note : The return type is BufferedReader since the NOAA endpoint returns a csv.
	 */
	public static BufferedReader parse(String url)
	{
		logger.info(url);
		try
		{
			URL ncdcURL = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(ncdcURL.openStream()));
			return br;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Constructs the NCDC URL given the US state, begin and end dates.
	 * @param beginDate The begin date of the interval.
	 * @param endDate The end date of the interval.
	 * @param state The US state.
	 * @return The URL string.
	 */
	public static String constructURL(StartAndEndDates startAndEndDates, String state) {
		
		//Calendar instances - To be changed to Java 8 time package.
		Calendar beginDate = getCalendarInstance(startAndEndDates.getStartDate());
		Calendar endDate = getCalendarInstance(startAndEndDates.getEndDate());
		
		StringBuilder urlBuilder = new StringBuilder();
		
		//Append the base URL.
		urlBuilder.append(BASE_URL);
		
		//Append Event Types - Flash flood, hail, thunderstorm wind, tornado.
		urlBuilder.append("eventType=%28C%29+Flash+Flood");
		urlBuilder.append("&eventType=%28C%29+Hail");
		urlBuilder.append("&eventType=%28C%29+Thunderstorm+Wind");
		urlBuilder.append("&eventType=%28C%29+Tornado");
		
		//Append Begin dates
		urlBuilder.append("&beginDate_mm=").append(prependZero((beginDate.get(Calendar.MONTH)+1)));
		urlBuilder.append("&beginDate_dd=").append(prependZero((beginDate.get(Calendar.DAY_OF_MONTH))));
		urlBuilder.append("&beginDate_yyyy=").append(beginDate.get(Calendar.YEAR));
		
		//Append End dates
		urlBuilder.append("&endDate_mm=").append(prependZero((endDate.get(Calendar.MONTH)+1)));
		urlBuilder.append("&endDate_dd=").append(prependZero((endDate.get(Calendar.DAY_OF_MONTH))));
		urlBuilder.append("&endDate_yyyy=").append(endDate.get(Calendar.YEAR));
		
		//Append Counties - Default is all counties.
		urlBuilder.append("&county=ALL");
		
		//Append the filter values for the events. All values are minimum because, NCDC does not work properly when filters are specified.
		urlBuilder.append("&hailfilter=0.00");
		urlBuilder.append("&tornfilter=0");
		urlBuilder.append("&windfilter=000");
		
		//Append the sorting order - Default.
		urlBuilder.append("&sort=DT");
		
		//Append the operation being made.
		urlBuilder.append("&submitbutton=Search");
		
		//Append the state index and name. e.g.: statefips=19%2CIOWA
		urlBuilder.append("&statefips=")
					.append(StateUtility.getStateIndex(state))
					.append("%2C")
					.append(state);
		
		logger.info(urlBuilder.toString());
		return urlBuilder.toString();
	}
	
	/**
	 * Prepends a zero if given integer < 10.
	 * @param i The given integer.
	 * @return The prepended integer as a string.
	 */
	private static String prependZero(int i)
	{
		String s = String.valueOf(i);
		if(i < 10) s = "0" + s;
		return s;
	}
	
	/**
	 * Get a Gregorian Calendar Instance.
	 * @param date
	 * @return
	 */
	private static Calendar getCalendarInstance(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		return c;
	}
}
