/**
 * 
 */
package com.src;


/**
 * @author rafee
 *
 */
public class ShippingPackage {
	
	static ShippingMap shippingMap = ShippingMap.getInstance();

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		reposition();
		Port arrLocation = ShippingMap.getRepositionedMap().get(Constants.inputPort);
		if(arrLocation == null ) {
			System.out.println(Constants.inputPort + " Port is invalid");
			System.exit(0);
		}
		System.out.println(arrLocation.toString());
		shippingMap.printShiplocationMap();
	}

	// place the containers correctly
	private static void reposition() {
		ShippingInventory shippingInventory = new ShippingInventory();
		
		Port port = shippingInventory.getNextPortDetails();
		port.setShippingStartLocation((new Location(0, 0, 0).getLocation()));

		// place the number of containers in the Array
		outerloop: for (int i = 0; i < Constants.MAX_ROW; i++) {
			for (int j = 0; j < Constants.MAX_COLUMN; j++) {
				for (int k = 0; k < Constants.MAX_HEIGHT; k++) {
					if (port != null) {
						if (port.getContainersCountFlag() != 0)
							shippingMap.updateShiplocation(i, j, k, port);
						
						// update map
						else if (port.getContainersCountFlag() == 0) {
							port.setShippingEndLocation((new Location(i, j, k).getLocation()));
							// fetch next port in the list
							port = shippingInventory.getNextPortDetails();
							if (port != null) {
								shippingMap.updateShiplocation(i, j, k, port);
								port.setShippingStartLocation((new Location(i, j, k).getLocation()));
							}
						} else
							break outerloop;
					}
				}
			}
		}
	}
}
