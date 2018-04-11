package com.src;

import java.util.Iterator;
import java.util.Map;

public class ShippingInventory {

	int port;
	int containerCount;
	private Iterator<?> it;

	public ShippingInventory() {
		it = Constants.containers.entrySet().iterator();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getContainerCount() {
		return containerCount;
	}

	public void setContainerCount(int containerCount) {
		this.containerCount = containerCount;
	}

	public Port getNextPortDetails() {

		if (it.hasNext()) {
			Map.Entry<Integer, Integer> input = (Map.Entry<Integer, Integer>) it.next();
			return new Port(input.getKey(), input.getValue());

		}
		return null;
	}
}
