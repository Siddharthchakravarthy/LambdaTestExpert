package com.test.Lambda;

public class Sumne {
	public static void main(String sid[]) {
		String s = "sbakjbgjkabg, akhs & fajbfa";
		
		String siddu[] = s.split(",");
		String sanjay = siddu[1];
		System.out.println(sanjay.split("&")[0]);
	}
}
