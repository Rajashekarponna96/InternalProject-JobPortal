package com.anil.example.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anil.example.springboot.entity.Panel;
import com.anil.example.springboot.entity.Student;

@Repository
public interface PanelRepository extends JpaRepository<Panel, Long> {
    
    List<Panel> findByName(String name);

	Panel findByEmail(String email);
	
	Panel findByPhoneNo(String phoneNo);
	
	
	 @Query("SELECT s FROM Student s WHERE CONCAT(s.name,s.lName,s.email,s.phoneNo,s.dob,s.address,s.tAddress,s.alternatePhoneNo.jobType,s.jobRole,s.experience,s.about,s.status) LIKE %?1%"
	  ) public List<Student> findAll(String keyword);
	 
	 @Query("SELECT s FROM Student s WHERE CONCAT(s.address) LIKE %?1%") public
	  List<Student> findByAddress(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.name) LIKE %?1%") public
	  List<Student> findThroughName(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.email) LIKE %?1%") public
	 List<Student> findThroughEmail(String keyword);
	 
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.alternatePhoneNo) LIKE %?1%")
	  public List<Student> findThroughalternatePhoneNo(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.phoneNo) LIKE %?1%") public
	  List<Student> findThroughPhoneNo(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.status) LIKE %?1%") public
	  List<Student> findThroughStatus(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.tAddress) LIKE %?1%") public
	 List<Student> findBytAddress(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.lName) LIKE %?1%") public
	  List<Student> findThroughlName(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.dob) LIKE %?1%") public
	  List<Student> findThroughdob(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.gender) LIKE %?1%") public
	  List<Student> findThroughgender(String keyword);
	 
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.jobType) LIKE %?1%") public
	  List<Student> findThroughjobType(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.jobRole) LIKE %?1%") public
	  List<Student> findThroughjobRole(String keyword);
	  
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.about) LIKE %?1%") public
	  List<Student> findByabout(String keyword);
	  
	  @Query("SELECT s FROM Student s WHERE CONCAT(s.experience) LIKE %?1%") public
	 List<Student> findThroughexperience(String keyword);
	 
	
			
    
    
}
