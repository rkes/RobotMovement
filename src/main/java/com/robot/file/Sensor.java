package com.robot.file;

import com.robot.thread.Leg;
import com.robot.thread.MovingLegQueue;
import com.robot.thread.PropertyFileReader;
import com.robot.thread.RobotExecutorService;

public class Sensor implements Runnable{

	private PropertyFileReader propReader=PropertyFileReader.getPropertyFileReader();
	private RobotExecutorService robotExecutorService=RobotExecutorService.getRobotExecutorServiceInstance();
	
	private MovingLegQueue legQueue =MovingLegQueue.getLegQueue();
	
	@Override
	public void run() {
		while(true){
			if(propReader.isFileModified()){
				loadData();
			}
		}
		
	}
	public void loadData(){
		Leg[] existingLegs=propReader.getExistingLeg();
		propReader.loadPropertyFile();
		Leg[] newLegs=propReader.getLegData();
		int i=0;
		Leg[] newLegAddition=new Leg[newLegs.length-existingLegs.length];
		System.out.println(newLegs.length+"    "+existingLegs.length+"    "+newLegAddition.length);
		
		for(int j=existingLegs.length;j<newLegs.length;j++){
			System.out.println("New Legs Submited");
			newLegs[j].setRobot(legQueue.getRobotName());
			legQueue.addInQueue(newLegs[j]);
		}
		
		System.out.println();
	}
	
}
