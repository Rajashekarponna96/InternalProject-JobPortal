package com.anil.example.springboot.service;


import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.anil.example.springboot.entity.Panel;
import com.anil.example.springboot.entity.Student;

public interface PanelService {


	
	List<Panel> getAllPanel();

	Panel addPanel(Panel Panel);

	//void deletePanelById(long id);
	
	void deleteStudentById(long id);

	Panel getPanel(Long id);

	
	Object findAll();

	public Panel findByEmail(String email);
	Panel findByPhoneNo(String phoneNo);
	
	void save(@Valid Panel panel);

	Panel findById(long id);

	void deletePaneltById(long id);

	//List<Panel> updateStudentDetails(Student student);
	//
//	List<Student> getAllStudent();
//
//	Student addStudent(Student student);
//
//	void deleteStudentById(Student student);
//
//	Student getStudent(Long id);
//
//	
//	Object findAll();
//	
//	Student findByPhoneNo(String phoneNo);
//
//	public Student findByEmail(String email);
//	
//	void save(@Valid Student student);
//
//	Student findById(long id);
//
//	List<Student> updateStudentDetails(Student student);
//
//
//	
//	
//	
//	
	
	
	
	
	
	
	
	

}
