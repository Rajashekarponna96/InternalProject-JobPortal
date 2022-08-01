package com.anil.example.springboot.service;


import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.anil.example.springboot.entity.Panel;
import com.anil.example.springboot.entity.Student;

import java.util.List;

public interface StudentService {


	
	List<Student> getAllStudent();

	Student addStudent(Student student);

	void deleteStudentById(Student student);

	Student getStudent(Long id);

	
	Object findAll();
	
	Student findByPhoneNo(String phoneNo);

	public Student findByEmail(String email);
	
	void save(@Valid Student student);

	Student findById(long id);

	List<Student> updateStudentDetails(Student student);

	
	
	void deleteById(Student student);

	void delete(Student student);

	void deleteStudentById(long id);

	Student updateStudent(Student student);

	void updateStudent(long id, Student student);
	
	List<Student> findByKeyword(String keyword);
	
	Page<Student> findPaginated(int pageNo, int pageSize);

	List<Student> findByAddress( String keyword);
	
	List<Student> findThroughName(String keyword);
	
	List<Student> findThroughEmail(String keyword);
	
	List<Student> findThroughalternatePhoneNo(String keyword);
	
	List<Student> findThroughPhoneNo(String keyword);
	
	List<Student> findThroughStatus(String keyword);


	
	

}
