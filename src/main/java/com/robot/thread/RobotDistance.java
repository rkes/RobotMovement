package com.robot.thread;

public class RobotDistance {
	
	private int distanceCovered;
	
	private int targetDistance;
	
	public void setTargetDistance(int targetDistance){
		this.targetDistance=targetDistance;
	}
	
	public int getTargetDistance(){
		return targetDistance;
	}
	
	private static RobotDistance instance=new RobotDistance();
	
	public static RobotDistance getRobotDistance(){
		return instance;
	}
	
	public int distanceToCover(){
		return  targetDistance-distanceCovered;
	}
	
	private RobotDistance(){distanceCovered=0;};
	
	public int getDistanceCovered(){
		return this.distanceCovered;
	}
	public void coverDistance(int distance){
		this.distanceCovered+=distance;
		System.out.println("Robot Covered Distance "+this.distanceCovered);
	}
	
}
