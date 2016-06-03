package com.pru.hk.ap.ws.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
  int id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
  
}