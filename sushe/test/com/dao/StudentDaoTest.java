package com.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.bean.Student;

public class StudentDaoTest {
	@Test
	public void testCheckLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllList() {
		  List<Student> li = new StudentDao().GetAllList(null, null);
		  for(Student s : li){
			  System.out.println(s.getStudent_Name());
		  }
	}

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllFirstBean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstBean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllBean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBean() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		Student s = new Student();
		s.setDomitory_Tel("1123490000966");
		s.setStudent_Name("grerl");
		s.setStudent_Password("123");
		StudentDao sd = new StudentDao();
		sd.Add(s);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
