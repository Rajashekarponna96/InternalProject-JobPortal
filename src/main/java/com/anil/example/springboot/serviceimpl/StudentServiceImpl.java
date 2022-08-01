package com.anil.example.springboot.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anil.example.springboot.entity.Student;
import com.anil.example.springboot.repository.StudentRepository;
import com.anil.example.springboot.service.StudentService;

@Service
public  class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;
    
    @Override 
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<>();
	    studentRepository.findAll()
	    .forEach(students::add);
		 return students;
	}
	@Override
	public Student addStudent(Student student) {
	     return studentRepository.save(student);
	}
	@Override
	public Student findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}
	
	public Student getStudent(long id) {
	     return studentRepository.findById(id)
	    		 .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	}
		
	@Override
	public void deleteStudentById(long id) {
		studentRepository.deleteById(id);
		
	}

	
	public void updateStudent(String id, Student student) {
	     studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Student student) {
		// TODO Auto-generated method stub
		
	}	
	@Override
	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(@Valid Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(long id, Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> updateStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findByPhoneNo(String phoneNo) {
			return studentRepository.findByPhoneNo(phoneNo);
	}

	@Override
	public List<Student> findByKeyword(String keyword) {
		
		return studentRepository.findAll(keyword);
		
	}

	@Override
	public List<Student> findByAddress(String keyword){
		
		return studentRepository.findByAddress(keyword);

	}
	@Override
	public Page<Student> findPaginated(int pageNo, int pageSize) {

		Pageable pageable=PageRequest.of(pageNo -1,pageSize);
		
		return this.studentRepository.findAll(pageable);
	}
	public List<Student> findThroughName(String keyword){
		return studentRepository.findThroughName(keyword);
	}
	
	public List<Student> findThroughEmail(String keyword){
		return studentRepository.findThroughEmail(keyword);
	}
	
	public List<Student> findThroughalternatePhoneNo(String keyword){
		return studentRepository.findThroughalternatePhoneNo(keyword);
	}
	
	public List<Student> findThroughPhoneNo(String keyword){
		return studentRepository.findThroughPhoneNo(keyword);
	}
	
	public List<Student> findThroughStatus(String keyword){
		return studentRepository.findThroughStatus(keyword);
	}
	
}