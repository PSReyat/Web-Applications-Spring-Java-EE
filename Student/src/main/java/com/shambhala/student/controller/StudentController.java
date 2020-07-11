package com.shambhala.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shambhala.student.entity.Admin;
import com.shambhala.student.entity.Student;
import com.shambhala.student.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	@RequestMapping("/")
	public String getStudentLoginPage() {
		return "student_login";
	}
	
	@RequestMapping("/admin")
	public String getAdminLoginPage() {
		return "admin_login";
	}
	
	@RequestMapping(value = "/studentlogin", method = RequestMethod.GET)
	public String getStudentLogin(@RequestParam("username") String username, 
						 		@RequestParam("password") String password,
						 		Model model) {
		
		Student student = sService.getStudent(username, password);
		
		if(student != null) {
			model.addAttribute("student", student);
			
			return "student_page";
		}else {
			model.addAttribute("loginError", true);
		}
		
		return "student_login";
		
	}
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String getAdminLogin(@RequestParam("username") String username, 
						 	  @RequestParam("password") String password,
						 	  Model model) {
		
		Admin admin = sService.getAdmin(password);
		
		if(admin != null) {
			List<Student> getList = sService.list();
			
			model.addAttribute("student", getList);
			
			return "student_list";
		}else {
			model.addAttribute("loginError", true);
		}
		
		return "admin_login";
	}
	
}
