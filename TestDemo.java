package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return (a + b);
		} else { 
			throw new IllegalArgumentException("Both parameters must be positive!");
			
		}
	}
	
	public boolean theNumberIsEven(int c) {
		if (c % 2 != 0) {
			throw new IllegalArgumentException("That number is not even!");
			
		} else {
			return true;
		}
	}
	
	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}

