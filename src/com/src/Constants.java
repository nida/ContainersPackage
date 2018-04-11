/**
 * 
 */
package com.src;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author rafee
 *
 */
public final class Constants {

	// input is hashmap - #port - #container count - staticmap
	public static final Map<Integer, Integer> containers;

	static {
		Map<Integer, Integer> lContainers = new TreeMap<Integer, Integer>(Collections.reverseOrder()); // TBD - add more
		lContainers.put(1, 15);
		lContainers.put(2, 110);
		//lContainers.put(3, 110);
		//lContainers.put(4, 118);
		lContainers.put(6, 18);
		lContainers.put(8, 18);
		lContainers.put(9, 18);
		lContainers.put(10, 18);
		containers = Collections.unmodifiableMap(lContainers);
	}

	public final static int inputPort = 10;// input

	// fixed dimensions
	public final static int MAX_HEIGHT = 5;
	public final static int MAX_COLUMN = 5;
	public final static int MAX_ROW = 10;
	public final static int MAX_COUNT = MAX_HEIGHT * MAX_COLUMN * MAX_ROW;

}
