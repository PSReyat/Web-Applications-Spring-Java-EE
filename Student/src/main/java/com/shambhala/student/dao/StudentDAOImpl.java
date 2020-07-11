package com.shambhala.student.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shambhala.student.entity.Admin;
import com.shambhala.student.entity.Student;


@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> list() {
		
		List<Student> listOfStudents = sessionFactory.getCurrentSession().createQuery("FROM students").list();
		
		return listOfStudents;
		
	}
	
	@Override
	public Student getStudent(String user, String pass) {
		String hql = "FROM students WHERE username = '" + user + "' AND password = '" + pass + "'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setMaxResults(1);
		
		Student student = (Student) query.uniqueResult();
		
		return student;
	}

	@Override
	public Admin getAdmin(String pass) {
		String hql = "FROM admin WHERE username = 'admin' AND password = '" + pass + "'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setMaxResults(1);
		
		Admin admin = (Admin) query.uniqueResult();
		
		return admin;
	}

	

	

}
