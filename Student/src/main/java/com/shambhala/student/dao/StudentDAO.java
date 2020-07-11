package com.shambhala.student.dao;

import java.util.List;

import com.shambhala.student.entity.Admin;
import com.shambhala.student.entity.Student;


public interface StudentDAO {
	
	List<Student> list();
	
	Student getStudent(String user, String pass);
	
	Admin getAdmin(String pass);
	
}
