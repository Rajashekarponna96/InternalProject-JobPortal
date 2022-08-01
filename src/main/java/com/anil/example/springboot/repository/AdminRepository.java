package com.anil.example.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.example.springboot.entity.Admin;

public interface AdminRepository extends  JpaRepository<Admin, String>{
	
	Admin findByusername (String username);
}
