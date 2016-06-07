package com.pru.hk.ap.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pru.hk.ap.ws.bean.Tank;


@Path("tanks")
public class TankResource extends UserResource{

    List<Tank> allTanks = new ArrayList<Tank>();
    public TankResource(){
  	  Tank o1 =null;
  	  //create 10 tanks
  	  for (int i=0;i<10;i++){
  	  o1 = new Tank();
	  allTanks.add(o1);
  	  }  	  
    }
    
  @GET
  @Path("{oid}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Tank getTank(@PathParam("oid")int id) {
    return allTanks.get(id);
  }
  

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Tank savePlainTextHello(Tank inputTank) throws Exception {

	    //String input = (String) inputJsonObj.get("input");
	    System.out.println("The input you sent is :" + inputTank);
	    
	    allTanks.add(inputTank);

	    return inputTank;
	  }
  
}

