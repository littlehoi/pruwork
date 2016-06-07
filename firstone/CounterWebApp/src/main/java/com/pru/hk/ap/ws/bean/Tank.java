package com.pru.hk.ap.ws.bean;

public class Tank extends User{
	private int shootRange;
	private int shootPower;
	private int speed;
	private Ability specialAbility;
	public int getShootRange() {
		return shootRange;
	}
	public void setShootRange(int shootRange) {
		this.shootRange = shootRange;
	}
	public int getShootPower() {
		return shootPower;
	}
	public void setShootPower(int shootPower) {
		this.shootPower = shootPower;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Ability getSpecialAbility() {
		return specialAbility;
	}
	public void setSpecialAbility(Ability specialAbility) {
		this.specialAbility = specialAbility;
	}
	@Override
	public String toString() {
		return "Tank [shootRange=" + shootRange + ", shootPower=" + shootPower
				+ ", speed=" + speed + ", specialAbility=" + specialAbility
				+ ", id=" + id + ", name=" + name + ", pass=" + pass
				+ ", rank=" + rank + ", world=" + world + ", scene=" + scene
				+ ", getShootRange()=" + getShootRange() + ", getShootPower()="
				+ getShootPower() + ", getSpeed()=" + getSpeed()
				+ ", getSpecialAbility()=" + getSpecialAbility() + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getPass()="
				+ getPass() + ", getRank()=" + getRank() + ", getWorld()="
				+ getWorld() + ", getScene()=" + getScene() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
