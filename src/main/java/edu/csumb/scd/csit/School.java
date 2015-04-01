package edu.csumb.scd.csit;
/**
 * Title: School.java
 * Abstract: This program can read a text file and create instances 
 * 			 of the Course, Instructor, Student objects. The program can also
 * 			 add instances of the Course, Instructor, Student objects with the
 * 			 call of a method. This program can display the info the school
 * 			 as well as a specific course or student. The program can also 
 * 			 delete a course or a student.
 * Author: Brian De Anda
 * ID: 2222
 * Date: Oct 23, 2014
 */

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class School {
	private String schoolName;
	private ArrayList<Instructor> instructors;
	private ArrayList<Course> courses;
	private ArrayList<Student> students;

	public School(String schoolName) {
		this.schoolName = schoolName;
		instructors = new ArrayList<Instructor>();
		courses = new ArrayList<Course>();
		students = new ArrayList<Student>();
	}

	public void readData(String fileName) {
		ArrayList<String> items = new ArrayList<String>();
		Path file = Paths.get(fileName);
		
		if (Files.exists(file) && Files.isReadable(file)) {

			try {
				BufferedReader reader = Files.newBufferedReader(file,
						Charset.defaultCharset());
				String line;
				while ((line = reader.readLine()) != null) {
					StringTokenizer tokenizer = new StringTokenizer(line, ",");
					while (tokenizer.hasMoreTokens()) {
						items.add(tokenizer.nextToken());
					}
				}
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		int thingsToAdd = Integer.valueOf(items.get(0));
		int itemIndex = 1;
		int index = 0;

		while (index < thingsToAdd) {
			addInstructor(Integer.valueOf(items.get(itemIndex++)),
					items.get(itemIndex++), items.get(itemIndex++),
					items.get(itemIndex++));
			index++;
		}

		thingsToAdd = Integer.valueOf(items.get(itemIndex++));
		index = 0;

		while (index < thingsToAdd) {
			addCourse(Integer.valueOf(items.get(itemIndex++)),
					items.get(itemIndex++),
					Integer.valueOf(items.get(itemIndex++)),
					items.get(itemIndex++));
			index++;
		}
		thingsToAdd = Integer.valueOf(items.get(itemIndex++));
		index = 0;

		while (index < thingsToAdd) {
			addStudent(Integer.valueOf(items.get(itemIndex++)),
					items.get(itemIndex++),
					Integer.valueOf(items.get(itemIndex++)),
					Double.valueOf(items.get(itemIndex++)),
					items.get(itemIndex++));
			index++;
		}
	}

	public void addInstructor(int employeeNum, String name, String email,
			String phoneNumber) {

		boolean repeat = true;

		Instructor newInstruct = new Instructor(employeeNum, name, email,
				phoneNumber);
		for (Instructor instructor : instructors) {
			if (instructor.getEmployeeNum() == employeeNum) {
				repeat = false;
			}
		}
		if (repeat)
			instructors.add(newInstruct);
		else
			System.out
					.println("Instructor addition failed - Duplicated employee number.");
	}

	public void addCourse(int courseNum, String courseTitle, int instructorNum,
			String room) {

		boolean instructorFound = false;

		for (Instructor instructor : instructors) {
			if (instructor.getEmployeeNum() == instructorNum) {
				instructorFound = true;
				break;
			}
		}
		if (instructorFound) {

			boolean repeat = true;

			Course newCourse = new Course(courseNum, courseTitle,
					instructorNum, room);
			for (Course course : courses) {
				if (course.getCourseNum() == courseNum) {
					repeat = false;
				}
			}
			if (repeat)
				courses.add(newCourse);
			else
				System.out
						.println("Course addition failed - Duplicated course number.");
		} else
			System.out
					.println("Cannot add this course because instructor does not exist!");

	}

	public void addStudent(int studentId, String name, int courseNum,
			double score, String grade) {
		boolean courseFound = false;

		for (Course course : courses) {
			if (course.getCourseNum() == courseNum) {
				courseFound = true;
				break;
			}
		}
		if (courseFound) {
			Student newStudent = new Student(studentId, name, courseNum, score,
					grade);
			students.add(newStudent);
		} else
			System.out
					.println("Cannot add this student because course does not exist!");
	}

	public void schoolInfo() {
		System.out.println("School Name: " + schoolName
				+ "\nInstructor Information");
		for (Instructor instructor : instructors) {
			System.out.println("\t" + instructor.getName());
		}

		System.out.println("Course Information");
		for (Course course : courses) {
			System.out.println("\t" + course.getCourseTitle());
		}

		System.out.println("Student Information");
		for (Student student : students) {
			System.out.print("\t" + student.getName() + ": ");
			for (Course course : courses) {
				if (student.getCourse() == course.getCourseNum())
					System.out.println(course.getCourseTitle());
			}
		}

	}

	public void courseInfo(int courseNum) {

		boolean found = false;
		int instructorNum = 0;
		String courseName = "";
		String room = "";
		int studentAmount = 0;
		double totalGrades = 0;

		for (Course course : courses) {
			if (course.getCourseNum() == courseNum) {
				found = true;
				instructorNum = course.getInstructorNum();
				courseName = course.getCourseTitle();
				room = course.getRoom();
			}
		}

		if (found) {
			System.out.println("Course Number:" + courseNum);
			System.out.print("Instructor: ");
			for (Instructor instructor : instructors) {
				if (instructor.getEmployeeNum() == instructorNum) {
					System.out.println(instructor.getName());
				}
			}
			System.out.println("Course Title: " + courseName);
			System.out.println("Room: " + room);
			System.out.println("Enrolled Students:");

			for (Student student : students) {
				if (student.getCourse() == courseNum) {
					studentAmount++;
					System.out.print("\t" + student.getName() + ": ");
					System.out.printf("%.2f", student.getScore());
					System.out.println(" (" + student.getGrade() + ")");
					totalGrades += student.getScore();
				}
			}
			totalGrades = (totalGrades / studentAmount);

			System.out.print("Course Average: ");
			System.out.printf("%.2f\n", totalGrades);
		} else
			System.out.println("Course does not exist!");
	}

	public void courseInfo() {

		System.out.println("Number of Course: " + courses.size());
		for (Course course : courses) {
			int enrolled = 0;
			System.out.print("\t" + course.getCourseNum() + ": ");
			for (Student student : students) {
				if (student.getCourse() == course.getCourseNum()) {
					enrolled++;
				}
			}
			System.out.println(enrolled + " enrolled");
		}
	}

	public void studentInfo(int studentId) {

		boolean found = false;
		String name = "";
		int classToAdd = 0;
		ArrayList<Integer> classes = new ArrayList<Integer>();
		ArrayList<Double> score = new ArrayList<Double>();
		ArrayList<String> grade = new ArrayList<String>();
		double totalGrade = 0;

		System.out.println("Student Number: " + studentId);

		for (Student student : students) {
			if (student.getId() == studentId) {
				found = true;
				name = student.getName();
				classToAdd = student.getCourse();
				if (!classes.contains(classToAdd)) {
					classes.add(classToAdd);
					score.add(student.getScore());
					grade.add(student.getGrade());
				}

			}
		}

		if (found) {
			System.out.println("Name: " + name);
			System.out.println("Course Enrolled:");
			for (int index = 0; index < classes.size(); index++) {
				System.out.print("\t" + classes.get(index) + ": ");
				System.out.printf("%.2f", score.get(index));
				System.out.println(" (" + grade.get(index) + ")");
				totalGrade += score.get(index);
			}

			totalGrade = (totalGrade / score.size());

			System.out.print("Course Average: ");
			System.out.printf("%.2f\n", totalGrade);
		} else
			System.out.println("Not exist!");
	}

	public Course getCourse(int courseNum) {
		Course courseTemp = new Course();

		for (Course course : courses) {
			if (course.getCourseNum() == courseNum)
				courseTemp = course;
		}

		return courseTemp;
	}

	public void deleteCourse(int courseNum) {
		boolean studentFound = false;
		for (Student student : students) {
			if (student.getCourse() == courseNum) {
				studentFound = true;
			}
		}

		Iterator<Course> iterator = courses.iterator();

		if (!studentFound) {
			while (iterator.hasNext()) {
				if (iterator.next().getCourseNum() == courseNum) {
					iterator.remove();
				}
			}
		} else
			System.out
					.println("This course can not be delete: \n(there is a student inrolled or course does not exist).");
	}

	public void graduateStudent(int studentId) {
		boolean studentFound = false;
		for (Student student : students) {
			if (student.getId() == studentId) {
				studentFound = true;
			}
		}

		Iterator<Student> iterator = students.iterator();

		if (studentFound) {
			while (iterator.hasNext()) {
				if (iterator.next().getId() == studentId) {
					iterator.remove();
				}
			}
		} else
			System.out.println("Not exist!");
	}

}
