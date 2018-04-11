package com.src;

import java.util.ArrayList;

public class Port {

	private int portNumber;
	private int containersCount;
	private int containersCountFlag;

	private ArrayList<Integer> shippingStartLocation;
	private ArrayList<Integer> shippingEndLocation;

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public ArrayList<Integer> getShippingStartLocation() {
		return shippingStartLocation;
	}

	public void setShippingStartLocation(ArrayList<Integer> shippingStartLocation) {
		this.shippingStartLocation = shippingStartLocation;
	}

	public ArrayList<Integer> getShippingEndLocation() {
		return shippingEndLocation;
	}

	public void setShippingEndLocation(ArrayList<Integer> location) {
		this.shippingEndLocation = location;
	}

	public int getContainersCount() {
		return containersCount;
	}

	public void setContainersCount(int containersCount) {
		this.containersCount = containersCount;
	}

	public int getContainersCountFlag() {
		return containersCountFlag;
	}

	public void updateContainersCountFlag() {
		this.containersCountFlag--;
	}

	Port(int aportNumber, int acontainersCount) {
		portNumber = aportNumber;
		containersCount = acontainersCount;
		containersCountFlag = containersCount;
	}

	protected void printPortDetails() {

		System.out.println("PortNumber: " + portNumber);
		System.out.println("Containers Count: " + containersCount);
		System.out.println("Shipping Start Location: " + shippingStartLocation.toString());
		System.out.println("Shipping End Location: " + shippingEndLocation.toString());
	}

	public String toString() {
		return "\nDetails of the result: \nPortNumber: " + portNumber + "\nContainers Count: " + containersCount + "\nShipping Start Location: "
				+ shippingStartLocation.toString() + "\nShipping End Location: " + shippingEndLocation.toString();
	}
	
}
