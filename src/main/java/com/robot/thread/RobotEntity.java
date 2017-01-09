package com.robot.thread;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RobotEntity {
	
	private Leg []legs;
	
	private MovingLegQueue legQueue=MovingLegQueue.getLegQueue();
	
	private int legNum;
	
	private RobotDistance roboDistance=RobotDistance.getRobotDistance();
	
	private String robotName;
	
	private PropertyFileReader config;
	 
	public RobotEntity(String robotName) throws IOException{
		this.config= PropertyFileReader.getPropertyFileReader();
		this.robotName=robotName;
		legQueue.setRobotName(this.robotName);
		this.legNum=0;
		this.legs=new Leg[this.config.getLegData().length];
		setLegs(this.config.getLegData(),false);
	}
	
	// In case of new Legs Addition
	public void setLegs(Leg []newsLegs,boolean isNewLegAdded){
		for(int i=this.legNum;i<this.legNum+newsLegs.length;i++){
			legs[i]=newsLegs[i];
			legs[i].setRobot(this.robotName);
			legQueue.addInQueue(legs[i]);
		}
		this.legNum+=newsLegs.length;		
	}
	
	public void move(){
		for(int i=0;i<legNum;i++){
			legs[i].setRobot(this.robotName);
			legQueue.addInQueue(legs[i]);
		}
		if(legQueue.queueLength()==0)
		roboDistance.coverDistance(legs[0].getLegDstance());
	}
	
	
}
