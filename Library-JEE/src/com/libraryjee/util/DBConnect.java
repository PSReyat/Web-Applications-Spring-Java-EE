package com.libraryjee.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnect {
	
	private static Properties props;
	private static Connection connection;
	private static String url;
	private static String driver;
	private static String username;
	private static String password;
	
	public static Connection openConnection() throws FileNotFoundException, IOException {
		
		File file = new File("C:\\Dev\\EclipseProjects\\Library-JEE\\WebContent\\db.properties");
		
		props = new Properties();
		props.load(new FileInputStream(file));
		
		url = props.getProperty("url");
		driver = props.getProperty("driver");
		username = props.getProperty("user");
		password = props.getProperty("pass");
		
		if(connection != null) {
			return connection;
		}else {
			
			try {
				Class.forName(driver);
				
				connection = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		return connection;
	}
}
