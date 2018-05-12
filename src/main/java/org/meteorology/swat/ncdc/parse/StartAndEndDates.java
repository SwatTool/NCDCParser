package org.meteorology.swat.ncdc.parse;

import java.util.Date;

/**
 * The start and end dates for making the call to NOAA.
 * @author Krishnan Subramanian
 *
 */
public class StartAndEndDates {
	private Date startDate;
	private Date endDate;
	
	/**
	 * 
	 * @return The start date.
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * 
	 * @param startDate The start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * 
	 * @return The end date.
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * @param endDate The end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
