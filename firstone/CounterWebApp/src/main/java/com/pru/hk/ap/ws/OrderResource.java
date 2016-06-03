package com.pru.hk.ap.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.pru.hk.ap.ws.bean.Order;

@Path("orders")
public class OrderResource {

    List<Order> response = new ArrayList<Order>();
    public OrderResource(){
  	  Order o1 = new Order();
  	  o1.setId(1);
  	  response.add(o1);
  	  o1 = new Order();
	  o1.setId(2);
	  response.add(o1);
  	  o1 = new Order();
	  o1.setId(3);
	  response.add(o1);
  	  o1 = new Order();
	  o1.setId(4);
	  response.add(o1);
    }
  @GET
  public List<Order> getAll() { 
    return response;
  }

  @GET
  @Path("{oid}")
  public Order getOrder(@PathParam("oid")int id) {
    return response.get(id);
  }
}

