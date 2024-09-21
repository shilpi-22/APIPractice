package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	RequestSpecification req;
	ResponseSpecification responseSpec;
	String token = "Basic c2hpbHBpZWt0YTIwMjFAZ21haWwuY29tOkFUQVRUM3hGZkdGMHUyYmZmeTlKR0prRklyeGZuM1poMFhYb2taX3AyckR5RGs4aXJ3YzRJUFBEQ3gwbEl3cnZSS1hpNlpwaGVZMFhMVFBhT3B5NnFMZkVWOTYwMU1uXy1FUUdFTG8xcUR6SmllTWxTTGk4N29neEtGYUpYMGU3VjBtdktPdGQ5eHNtTlQ5QlQxRURFOHQtUUFrUDVwY0JzYkdOejFRVTZvdkxDTzBNSmpGbEx4cz0xMjdFMzI3Ng==\r\n"
			+ "";

	
	public RequestSpecification RequestSpecification() throws IOException {
		PrintStream ps = new PrintStream(new FileOutputStream("logging" + System.currentTimeMillis() + ".txt"));
	
			req = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseurl")).addHeader("Authorization", token)
					 .setContentType("application/json")
					 .addFilter(RequestLoggingFilter.logRequestTo(ps))
					 .addFilter(ResponseLoggingFilter.logResponseTo(ps))
					 .build();
		 return req;
	}
	
	
	
	public ResponseSpecification ResponseSpecification() throws FileNotFoundException {
		 responseSpec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType("application/json").build();
		 return responseSpec;
	}
	
	public static String getGlobalValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("../APIFramework/src/test/java/resources/globalData.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}
}
