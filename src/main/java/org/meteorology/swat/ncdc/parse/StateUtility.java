package org.meteorology.swat.ncdc.parse;

import java.util.HashMap;
import java.util.Map;

/**
 * A utility class to handle useful US state related methods and constants.
 * @author Krishnan Subramanian
 *
 */
public class StateUtility {
	
	/**
	 * Private constructor to prevent instantiation.
	 */
	private StateUtility() {	}

	private static Map<String, Integer> stateIndices = new HashMap<String, Integer>();
	
	/**
	 * A static code block to add the states and their indices.
	 */
	static {
		stateIndices.put("ALABAMA",1);
		stateIndices.put("ALASKA",2);		
		stateIndices.put("ARIZONA",4);
		stateIndices.put("ARKANSAS",5);
		stateIndices.put("CALIFORNIA",6);		
		stateIndices.put("COLORADO",8);
		stateIndices.put("CONNECTICUT",9);
		stateIndices.put("DELAWARE",10);
		stateIndices.put("DISTRICT+OF+COLUMBIA",11);
		stateIndices.put("FLORIDA",12);
		stateIndices.put("GEORGIA",13);
		stateIndices.put("HAWAII",14);		
		stateIndices.put("IDAHO",16);
		stateIndices.put("ILLINOIS",17);
		stateIndices.put("INDIANA",18);
		stateIndices.put("IOWA",19);
		stateIndices.put("KANSAS",20);
		stateIndices.put("KENTUCKY",21);
		stateIndices.put("LOUSIANA",22);
		stateIndices.put("MAINE",23);
		stateIndices.put("MARYLAND",24);
		stateIndices.put("MASSACHUSETTS",25);
		stateIndices.put("MICHIGAN",26);
		stateIndices.put("MINNESOTA",27);
		stateIndices.put("MISSISSIPPI",28);
		stateIndices.put("MISSOURI",29);
		stateIndices.put("MONTANA",30);
		stateIndices.put("NEBRASKA",31);
		stateIndices.put("NEVADA",32);
		stateIndices.put("NEW+HAMPSHIRE",33);
		stateIndices.put("NEW+JERSEY",34);
		stateIndices.put("NEW+MEXICO",35);
		stateIndices.put("NEW+YORK",36);
		stateIndices.put("NORTH+CAROLINA",37);
		stateIndices.put("NORTH+DAKOTA",38);
		stateIndices.put("OHIO",39);
		stateIndices.put("OKLAHOMA",40);
		stateIndices.put("OREGON",41);
		stateIndices.put("PENNSYLVANIA",42);
		stateIndices.put("RHODE+ISLAND",43);
		stateIndices.put("SOUTH+CAROLINA",44);
		stateIndices.put("SOUTH+DAKOTA",46);
		stateIndices.put("TENNESSEE",47);
		stateIndices.put("TEXAS",48);
		stateIndices.put("UTAH",49);
		stateIndices.put("VERMONT",50);
		stateIndices.put("VIRGINIA",51);
		stateIndices.put("WASHINGTON",53);
		stateIndices.put("WEST+VIRGINIA",54);
		stateIndices.put("WISCONSIN",55);
		stateIndices.put("WYOMING",56);
	}
	
	/**
	 * Gets the state index as specified by NCDC (NOAA).
	 * @param state The US state to find the index for.
	 * @return The index of the given state. (Default value - 0).
	 */
	public static int getStateIndex(String state) {
		return stateIndices.getOrDefault(state, 0);
	}
}
