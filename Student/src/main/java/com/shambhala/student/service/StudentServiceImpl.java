package com.shambhala.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shambhala.student.dao.StudentDAO;
import com.shambhala.student.entity.Admin;
import com.shambhala.student.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO sDAO;
	
	@Override
	public List<Student> list() {
		return sDAO.list();
	}
	
	@Override
	public Student getStudent(String user, String pass) {
		return sDAO.getStudent(user, pass);
	}

	@Override
	public Admin getAdmin(String pass) {
		return sDAO.getAdmin(pass);
	}



	
	

}
