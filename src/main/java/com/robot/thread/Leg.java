package com.robot.thread;

public class Leg implements Runnable {

	String legName;
	String robot;

	public Leg(String str, int legDistance) {
		this.legName = str;
		this.legDistance = legDistance;
	}

	public void setRobot(String robot) {
		this.robot = robot;
	}

	public String getLegName(){
		return this.legName;
	}
	
	private int legDistance;

	@Override
	public void run() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Moving Leg \t : " + legName + " \t Of Robot " + robot);
	}

	public int getLegDstance() {
		return legDistance;
	}

}
