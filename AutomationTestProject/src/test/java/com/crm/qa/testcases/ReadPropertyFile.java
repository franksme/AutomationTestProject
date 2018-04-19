package com.crm.qa.testcases;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("C:\\Users\\1\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(input);
		System.err.println("Url: " + prop.getProperty("url"));
		System.err.println("Username: " + prop.getProperty("username"));
		System.err.println("Password: " + prop.getProperty("password"));
		System.err.println("Browser : " + prop.getProperty("browser"));
	}

}
