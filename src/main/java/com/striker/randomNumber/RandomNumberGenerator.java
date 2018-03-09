package com.striker.randomNumber;

import java.util.Random;

public class RandomNumberGenerator {

	public int generateRandomNumber(){
		Random rand = new Random();
	        return rand.nextInt(10000);	
	}
 
}
