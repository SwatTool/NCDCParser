package org.meteorology.swat.ncdc.parse;

import java.util.Date;

/**
 * The begin and end dates for making the call to NOAA.
 * @author Krishnan Subramanian
 *
 */
public class BeginAndEndDates {
	private Date beginDate;
	private Date endDate;
	
	/**
	 * 
	 * @return The begin date.
	 */
	public Date getBeginDate() {
		return beginDate;
	}
	
	/**
	 * 
	 * @param beginDate The begin date.
	 */
	public void setBeginDate(Date startDate) {
		this.beginDate = startDate;
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
