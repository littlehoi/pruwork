package com.pru.hk.ap.util;

import java.util.Random;

public class ThreadLocalRandom {

	public static int current(int start, int end) {
		Random r = new Random();
		return showRandomInteger(start,end,r);
	}
	 private static int showRandomInteger(int aStart, int aEnd, Random aRandom){
		    if (aStart > aEnd) {
		      throw new IllegalArgumentException("Start cannot exceed End.");
		    }
		    //get the range, casting to long to avoid overflow problems
		    long range = (long)aEnd - (long)aStart + 1;
		    // compute a fraction of the range, 0 <= frac < range
		    long fraction = (long)(range * aRandom.nextDouble());
		    int randomNumber =  (int)(fraction + aStart);    
		    return randomNumber;
		  }
		  
}
