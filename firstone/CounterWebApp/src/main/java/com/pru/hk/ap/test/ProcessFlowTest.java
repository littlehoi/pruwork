package com.pru.hk.ap.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pru.hk.ap.util.Util;
import com.pru.hk.ap.ws.bean.Tank;
import com.pru.hk.ap.ws.bean.User;

public class ProcessFlowTest {
	String cws = "http://localhost:8080/CounterWebApp/webresources/";
	String userURL = cws+"users/";
	String tankURL = cws+"tanks/";

	@Test
	public void consumeUser() {
		 try{
			 	URL url = new URL(userURL+Util.randint(1,5));
		        URLConnection yc = url.openConnection();
			 	 BufferedReader in = new BufferedReader(new InputStreamReader(
                         yc.getInputStream()));
	            Gson gson = new GsonBuilder().create();
	            User p = gson.fromJson(in, User.class);
	            System.out.println(p);
	        
	}catch (Exception e){
		e.printStackTrace();
	}
	}
	
	@Test
	public void consumeUsers() {
		try {
			URL url = new URL(userURL);
			URLConnection yc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					yc.getInputStream()));
			Gson gson = new GsonBuilder().create();
			 List<User> uList = gson.fromJson(in, new TypeToken<ArrayList<User>>(){}.getType());
			System.out.println(uList);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void consumeTanks() {
		try {
			URL url = new URL(tankURL);
			URLConnection yc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					yc.getInputStream()));
			Gson gson = new GsonBuilder().create();
			 List<Tank> uList = gson.fromJson(in, new TypeToken<ArrayList<Tank>>(){}.getType());
			System.out.println(uList);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
