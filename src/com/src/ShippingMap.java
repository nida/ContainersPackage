package com.src;

import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class ShippingMap {

	private static int totalContainerCount;
	private static int shiplocation[][][];
	private static  Port port;
	private static ShippingMap single_instance = null;
	private static Map<Integer, Port> repositionedMap;

	public static ShippingMap getInstance() {
		if (single_instance == null)
			single_instance = new ShippingMap();

		return single_instance;
	}

	private ShippingMap() {
		totalContainerCount = 0;
		shiplocation = new int[Constants.MAX_ROW][Constants.MAX_COLUMN][Constants.MAX_HEIGHT];
		repositionedMap = new HashMap<>();
	}

	public static int getTotalContainerCount() {
		return totalContainerCount;
	}

	public void setTotalContainerCount(int totalContainerCount) {
		ShippingMap.totalContainerCount = totalContainerCount;
	}

	public int[][][] getShiplocation() {
		return shiplocation;
	}

	public static Port getPort() {
		return port;
	}

	public static void setPort(Port port) {
		ShippingMap.port = port;
	}

	public static Map<Integer, Port> getRepositionedMap() {
		return repositionedMap;
	}

	public static void setRepositionedMap(Map<Integer, Port> repositionedMap) {
		ShippingMap.repositionedMap = repositionedMap;
	}

	public void updateShiplocation(int row, int column, int height, Port port) {
		shiplocation[row][column][height] = port.getPortNumber();
		increaseTotalContainerCount();
		if(getTotalContainerCount() >= Constants.MAX_COUNT) {
			System.out.println("WARNING: " + port.getPortNumber() + " exceeds the current load");
			System.out.println("Check input Count or consider another shipment");
		}
		port.updateContainersCountFlag();
		ShippingMap.setPort(port);
		repositionedMap.put(port.getPortNumber(), port);
	}

	protected void increaseTotalContainerCount() {
		totalContainerCount++;
	}

	// Printing the listed map
	public void printShiplocationMap() {
		System.out.println("Total Containers Shipped: " + getTotalContainerCount());
		System.out.println("Printing Ship Location Map");
		for (int i = 0; i < Constants.MAX_ROW; i++) {
			for (int j = 0; j < Constants.MAX_COLUMN; j++) {
				for (int k = 0; k < Constants.MAX_HEIGHT; k++) {
					System.out.print(shiplocation[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		if(getTotalContainerCount() == Constants.MAX_COUNT) {
			System.out.println("INFO: MAXIMUM CAPACITY REACHED");
		}
		else {
			System.out.println("INFO: CAPACITY REMAINING: " + (Constants.MAX_COUNT - getTotalContainerCount()));
		}

	}

}
