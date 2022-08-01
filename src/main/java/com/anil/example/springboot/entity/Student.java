package com.anil.example.springboot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
    @Column(name = "lname")
    private String lName;
    
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;


	@Column(name = "phone_no")
    private String phoneNo;
    
	 @Column(name = "dob")
	    private String dob;
	 
	 @Column(name = "gender")
	    private String gender;
	 
    @Column(name = "Address")
    private String address;
    
    @Column(name = "tAddress")
    private String tAddress;
    
    @Column(name = "alternatePhoneNo")
    private long alternatePhoneNo;
    
    @Column(name = "jobType")
    private String jobType;
    
    @Column(name = "jobRole")
    private String jobRole;
    
    @Column(name = "experience")
    private String experience;
    
    @Column(name = "about")
    private String about;
    
    @Column(name = "InterviwStatus")
    private String status;

    
	public Student() {
		
	}

	public Student(long id, @NotBlank(message = "Name is mandatory") String name, String lName,
			@NotBlank(message = "Email is mandatory") String email, String phoneNo, String dob, String gender,
			String address, String tAddress, long alternatePhoneNo, String jobType, String jobRole, String experience,
			String about, String status) {
		super();
		this.id = id;
		this.name = name;
		this.lName = lName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.tAddress = tAddress;
		this.alternatePhoneNo = alternatePhoneNo;
		this.jobType = jobType;
		this.jobRole = jobRole;
		this.experience = experience;
		this.about = about;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String gettAddress() {
		return tAddress;
	}

	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}

	public long getAlternatePhoneNo() {
		return alternatePhoneNo;
	}

	public void setAlternatePhoneNo(long alternatePhoneNo) {
		this.alternatePhoneNo = alternatePhoneNo;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lName=" + lName + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", tAddress=" + tAddress
				+ ", alternatePhoneNo=" + alternatePhoneNo + ", jobType=" + jobType + ", jobRole=" + jobRole
				+ ", experience=" + experience + ", about=" + about + ", status=" + status + "]";
	}
    
    

	

	}