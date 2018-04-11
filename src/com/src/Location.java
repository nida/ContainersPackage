package com.src;

import java.util.ArrayList;

public class Location {

	private static int row;
	private static int column;
	private static int height;

	private static ArrayList<Integer> location;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		Location.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		Location.column = column;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		Location.height = height;
	}

	public static ArrayList<Integer> getLocation() {
		return location;
	}

	public static void setLocation(ArrayList<Integer> location) {
		Location.location = location;
	}

	public Location(int row, int column, int height) {
		Location.row = row;
		Location.column = column;
		Location.height = height;
		location = new ArrayList<Integer>();
		location.add(row);
		location.add(column);
		location.add(height);

	}

}
