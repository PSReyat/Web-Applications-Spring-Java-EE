package com.shambhala.student.service;

import java.util.List;

import com.shambhala.student.entity.Admin;
import com.shambhala.student.entity.Student;


public interface StudentService {
	
	List<Student> list();
	
	Student getStudent(String user, String pass);
	
	Admin getAdmin(String pass);
	
}
