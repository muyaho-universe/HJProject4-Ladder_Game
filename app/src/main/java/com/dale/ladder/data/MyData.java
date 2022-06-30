package com.dale.ladder.data;

import java.util.HashMap;

public class MyData {
	private static int peopleNumber; // n
	private static int bridgeNumber; // m
	private static int oneWidth; // d
	private static int oneHeight; // h
	
	public static HashMap<Integer, String> peopleData = new HashMap<Integer, String>();
	public static HashMap<Integer, String> targetData = new HashMap<Integer, String>();
	
	public static int getPeopleNumber() {
		return peopleNumber;
	}
	public static void setPeopleNumber(int peopleNumber) {
		MyData.peopleNumber = peopleNumber;
	}
	public static int getBridgeNumber() {
		return bridgeNumber;
	}
	public static void setBridgeNumber(int bridgeNumber) {
		MyData.bridgeNumber = bridgeNumber;
	}
	public static int getOneWidth() {
		return oneWidth;
	}
	public static void setOneWidth(int oneWidth) {
		MyData.oneWidth = oneWidth;
	}
	public static int getOneHeight() {
		return oneHeight;
	}
	public static void setOneHeight(int oneHeight) {
		MyData.oneHeight = oneHeight;
	}
}
