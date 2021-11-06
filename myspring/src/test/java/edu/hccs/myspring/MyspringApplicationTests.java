package edu.hccs.myspring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.*;
import org.springframework.boot.SpringApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



import org.springframework.context.annotation.*;

@SpringBootTest
class MyspringApplicationTests {

	static ArrayList<Student> students = new ArrayList<Student>();
	public static void main(String[] args) throws ParseException {
		
		
		
			
			Client client = Client.create();
			WebResource webResource = client.resource("https://hccs-advancejava.s3.amazonaws.com/student_course.json");
			ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
			if(clientResponse.getStatus() != 200) {
				throw new RuntimeException("Failed" + clientResponse.toString());
			}
			
			JSONArray jsonArray = (JSONArray) new JSONParser().parse(clientResponse.getEntity(String.class));
			
			Iterator<Object> it = jsonArray.iterator();
			while(it.hasNext()) {
				
				JSONObject jsonObject = (JSONObject)it.next();
				
				
				try {
					ConfigurableApplicationContext context = SpringApplication.run(MyspringApplicationTests.class, args);
				
					Student student = context.getBean(Student.class);
					student.setEmail(jsonObject.get("email").toString());
					student.setFirstName(jsonObject.get("name").toString());
					
							students.add(student);
							
							
				
				}catch(Exception e) {
					//There is an error in the JSON file so this student cannot be added to the array.
					System.out.println("Student " + jsonObject.get("first_name").toString() + " could not be added.");
					continue;
				}
				
			}
		}
		
		
		
		
		
		
		
	}
	



