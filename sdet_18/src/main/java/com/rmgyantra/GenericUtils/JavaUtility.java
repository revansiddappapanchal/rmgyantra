package com.rmgyantra.GenericUtils;

import java.util.Random;

public class JavaUtility {

	/*
	 * this method will generate a random number
	 */
	public int randomNumber() {
	        Random random = new Random();
	        int randomData = random.nextInt(5000);
	        return randomData;
	}
}
