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

import com.pru.hk.ap.ws.bean.User;


@Path("users")
public class UserResource {

    List<User> allUsers = new ArrayList<User>();
    public UserResource(){
  	  User o1 =null;
  	  //create 10 users
  	  for (int i=0;i<10;i++){
  	  o1 = new User();
	  allUsers.add(o1);
  	  }
  	  
    }
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> getAll() { 
    return allUsers;
  }

  @GET
  @Path("{oid}")
  @Produces(MediaType.APPLICATION_JSON)
  public User getUser(@PathParam("oid")int id) {
    return allUsers.get(id);
  }
  

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public User sayPlainTextHello(User inputUser) throws Exception {

	    //String input = (String) inputJsonObj.get("input");
	    System.out.println("The input you sent is :" + inputUser);
	    
	    allUsers.add(inputUser);

	    return inputUser;
	  }
  
}

