package edu.csumb.scd.csit;
/**
 * Title: Course.java
 * Abstract: This program creates an object which includes a
 * 			 unique course number, course title, instructor’s
 * 		     number, and class room. 
 * Author: Brian De Anda
 * ID: 2222
 * Date: Oct 23, 2014
 */
public class Course {
	
	private int courseNum;
	private String courseTitle;
	private int instructorNum;
	private String room;
	
	public Course() {
		this.courseNum = 0; 
		this.courseTitle = "";
		this.instructorNum = 0;
		this.room = "";
	}
	
	public Course(int courseNum, String courseTitle, int instructorNum,
			String room) { 
		this.courseNum = courseNum; 
		this.courseTitle = courseTitle;
		this.instructorNum = instructorNum;
		this.room = room;
	}
	
	public void updateLocation(String room)
	{
		this.room = room;
	}
	
	public void setCourseNum(int courseNum)
	{
		this.courseNum = courseNum;
	}
	
	public void setCourseTitle(String courseTitle)
	{
		this.courseTitle = courseTitle;
	}
	
	public void setInstructorNum(int instructorNum)
	{
		this.instructorNum = instructorNum;
	}
	
	public void setRoom(String room)
	{
		this.room = room;
	}
	
	public int getCourseNum()
	{
		return courseNum;
	}
	
	public String getCourseTitle()
	{
		return courseTitle;
	}
	
	public int getInstructorNum()
	{
		return instructorNum;
	}
	
	public String getRoom()
	{
		return room;
	}
}
