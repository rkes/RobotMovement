package com.robot.thread;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.robot.file.Sensor;

public class RobotRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		Thread th=new Thread(new Sensor());
		th.setDaemon(true);
		th.start();
		//RobotEntity robotEntity=new RobotEntity("Mars Rover");
		//robotEntity.move();
		RobotEntity roboEntity=new RobotEntity("Mars Rover");
		
		RobotExecutorService execSevrice=RobotExecutorService.getRobotExecutorServiceInstance();
		execSevrice.runRobot();
		
		
	//			executorService.submit(new Leg());
		
	}

}
