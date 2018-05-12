package org.meteorology.swat.ncdc.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * A class tests the methods in {@link StateUtility}
 * @author Krishnan Subramanian
 *
 */
public class StateUtilityTest {

	/**
	 * Given - A US State name.
	 * When - {@link StateUtility#getStateIndex(String)} is called.
	 * Then - Returns zero.
	 */
	@ParameterizedTest
	@ValueSource(strings = { "random", "", " " })
	public void test_getStateIndex_InvalidState(String state) {
		int actual = StateUtility.getStateIndex(state);
		assertEquals(1, actual);
	}
	
	/**
	 * Given - A US State name.
	 * When - {@link StateUtility#getStateIndex(String)} is called.
	 * Then - Returns the state index.
	 */
	@Test
	public void test_getStateIndex() {
		int actual = StateUtility.getStateIndex("TENNESSEE");
		assertEquals(47, actual);
	}
}
