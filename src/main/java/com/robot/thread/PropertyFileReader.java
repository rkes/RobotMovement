package com.robot.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	private Properties properties = new Properties();

	private RobotDistance roboDistance = RobotDistance.getRobotDistance();

	private static PropertyFileReader propFileReader = new PropertyFileReader();

	private FileInputStream fios;

	private long lastModified;

	private Leg[] legs;

	public static PropertyFileReader getPropertyFileReader() {
		return propFileReader;
	}

	private PropertyFileReader() {
		loadProperties();
	}

	private void loadProperties() {
		this.lastModified = (new File("Robot.properties")).lastModified();
		loadPropertyFile();
		roboDistance.setTargetDistance(new Integer(properties.get("distance") + ""));

	}

	public void loadPropertyFile() {
		try {
			this.fios = new FileInputStream("Robot.properties");
			properties.load(this.fios);
		} catch (IOException exp) {

		}
	}

	public boolean isFileModified() {
		File file = new File("Robot.properties");
		if (file.lastModified() > this.lastModified) {
			this.lastModified = file.lastModified();
			return true;
		}
		return false;
	}

	public Leg[] getLegData() {
		String[] legStr = properties.getProperty("legs").split(",");
		Leg[] leg = new Leg[legStr.length];
		for (int i = 0; i < legStr.length; i++) {
			String[] legLine = legStr[i].split("=");
			leg[i] = new Leg(legLine[0], new Integer(legLine[1]));
		}
		this.legs = leg;
		return leg;
	}

	public Leg[] getExistingLeg() {
		return this.legs;
	}

	public static void main(String[] args) throws IOException {
		PropertyFileReader propReader = new PropertyFileReader();
		propReader.getLegData();
		System.out.println();
	}

}
