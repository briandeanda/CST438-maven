package edu.csumb.scd.csit;
/**
 * Title: Student.java
 * Abstract: This program creates an object which includes a
 * 			 student’s unique ID, name, course enrolled, 
 * 			 final score, and letter grade. 
 * Author: Brian De Anda
 * ID: 2222
 * Date: Oct 23, 2014
 */
public class Student {
		
	private int id;
	private String name;
	private int course;
	private double score;
	private String grade;
	
	public Student(int studentId, String name, int courseNum,
			double score, String grade) {
		this.id = studentId;
		this.name = name;
		this.course = courseNum;
		this.score = score;
		this.grade = grade;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setCourse(int course)
	{
		this.course = course;
	}
	
	public void setScore(double score)
	{
		this.score = score;
	}
	
	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCourse()
	{
		return course;
	}
	
	public double getScore()
	{
		return score;
	}
	
	public String getGrade()
	{
		return grade;
	}
	
}
