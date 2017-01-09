package com.robot.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MovingLegQueue {
	
	private static MovingLegQueue movingLegQueue=new MovingLegQueue();
	
	private MovingLegQueue(){
		
	}
	
	public static MovingLegQueue getLegQueue(){
		return movingLegQueue;
	}
	
	private String robotName="";
	
	BlockingDeque<Leg> deque = new LinkedBlockingDeque<Leg>();
	
	public void addInQueue(Leg leg){
	
		try {
			deque.put(leg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Leg getLegFromQueue(){
		Leg leg=null;
		try {
			 leg=deque.takeFirst();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return leg;
	}
	
	public Leg peek(){
		return deque.peek();
	}
	
	public int queueLength(){
		return deque.size();
	}
	
	public void setRobotName(String robotName){
		this.robotName=robotName;
	}
	
	public String getRobotName(){
		return this.robotName;
	}
}
