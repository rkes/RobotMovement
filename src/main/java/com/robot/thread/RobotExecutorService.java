package com.robot.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RobotExecutorService {

	private static RobotExecutorService robotExecutorService=new RobotExecutorService();
	
	private MovingLegQueue legQueue=MovingLegQueue.getLegQueue();
	
	private ExecutorService executorService;
	
	private RobotDistance robotDistance=RobotDistance.getRobotDistance();
	
	private RobotExecutorService(){
		executorService=Executors.newFixedThreadPool(1);
	}
	
	public static RobotExecutorService getRobotExecutorServiceInstance(){
		return robotExecutorService;
	}
	
	public void runRobot(){
		while(robotDistance.distanceToCover()>0){
		Leg leg=null;
		int dist=0;
		int len=legQueue.queueLength();
		int i=0;
		while(len>i){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			leg=legQueue.getLegFromQueue();
			legQueue.addInQueue(leg);
			dist=leg.getLegDstance();
			executorService.submit(leg);
			i++;
		}
		robotDistance.coverDistance(dist);
		}
		executorService.shutdown();
	}
	public void shutDown(){
		executorService.shutdown();
	}
	public boolean isTerminated(){
		return executorService.isTerminated();
	}
}
