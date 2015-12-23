package com.vekomy;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
	private static ReadPropertyFile currentObject;

	private ReadPropertyFile() {
	}

	public static ReadPropertyFile getInstance() {
		if (currentObject == null) {
			currentObject = new ReadPropertyFile();
		}
		return currentObject;

	}

	public Properties getProperties(Class<?> clz){
	Properties properties = new Properties();
	InputStream inputStream = null;
	try {
		inputStream = clz.getClassLoader().getResourceAsStream("tags.properties");
		if(inputStream == null){
			System.out.println(" tags.properties file Not found.");
		}
		properties.load(inputStream);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		if(inputStream != null){
			try{
				inputStream.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	return properties;
}
}