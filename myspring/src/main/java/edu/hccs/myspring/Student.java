package edu.hccs.myspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Student {
	
	//private variables
	private int id;
	private String firstName;
	private double gpa;
	private String email;
	private String gender;
	@Autowired
	Course course;
	
	//Default Constructor
	Student(){
		System.out.println("Inside student constructor");
	}
	
	//Parameterized Constructor
	Student(int id, String firstName, double gpa, String email, String gender){
		
		this.id = id;
		this.firstName = firstName;
		this.gpa = gpa;
		this.email = email;
		this.gender = gender;
	}
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	//toString method
	public String toString() {
		return ("Id = " + this.id + "\n" +
	"Name = " + this.firstName + "\n" + 
				"gpa = " + this.gpa + "\n" +
	"Email = " + this.email + "\n" +
	"Gender = " + this.gender);
	}
	
	
}
