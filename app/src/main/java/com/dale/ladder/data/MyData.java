package com.dale.ladder.data;

public class MyData {
	private static int peopleNumber; //n
	private static int bridgeNumber; //m
	
	
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
}
