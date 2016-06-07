package com.pru.hk.ap.util;
import java.util.Random;

import com.pru.hk.ap.ws.bean.Award;
import com.pru.hk.ap.ws.bean.Rank;
import com.pru.hk.ap.ws.bean.Scene;
import com.pru.hk.ap.ws.bean.World;
public class Util {

	public static Rank randRank() {
		Rank r =new Rank();
		r.setAward(randomEnum(Award.class));
		r.setRankNumber(randint(1,100));
		return r;
	}

	public static String randPass() {
		return randString(8);
	}
	public static String randName() {
		return "name"+randString(10);
	}

	public static int randint(int start, int end) {
	return ThreadLocalRandom.current(start, end);
	}
	
	public static String randString(int i) {
		char[] alphNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		Random rnd = new Random();

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < 5; j++)
		    sb.append(alphNum[rnd.nextInt(alphNum.length)]);
		String string = sb.toString();

		System.out.println(string);
		return string;
	}

	public static World randWorld() {
		return randomEnum(World.class);
	}

	public static Scene randScene() {
		return randomEnum(Scene.class);
	}
	  public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
	        int x = ThreadLocalRandom.current(0,clazz.getEnumConstants().length-1);
	        System.out.println(x);
	        return clazz.getEnumConstants()[x];
	    }
}
