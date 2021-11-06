package edu.hccs.myspring;

import org.springframework.stereotype.Component;

@Component
public class Course {
	private String courseNo;
	private String grade;
	private int creditHours;
	
	//Default Constructor
	Course(){
		System.out.println("Inside course constructor");
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", grade=" + grade + ", creditHours=" + creditHours + "]";
	}
	
}
