package com.pru.hk.ap.ws.bean;

import com.pru.hk.ap.util.Util;

public class User {
	static int maxId=0;
	int id;
	String name;
	String pass;
	Rank rank;
	World world;
	Scene scene;

	public User() {
		super();
		maxId++;
		this.id = maxId;
		name=Util.randName();
		pass=Util.randPass();
		rank=Util.randRank();
		world=Util.randWorld();
		scene=Util.randScene();
		
	}
	public static int getMaxId() {
		return maxId;
	}

	public static void setMaxId(int maxId) {
		User.maxId = maxId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass
				+ ", rank=" + rank + ", world=" + world + ", scene=" + scene
				+ "]";
	}
	

}
