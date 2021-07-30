package com.a0521.pma.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Employee {

	//==============THIS IS ID================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//700
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "project_seq")
	private long employeeId;
	//==============THIS IS ID================================================
	
	private String firstName;
	private String lastName;
	private String email;
	
//	@ManyToOne(    // <==> @OneToMany in Project.java
//			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//			fetch = FetchType.LAZY //EAGER/LAZY: The way to load, Lazy-> only the project related (industry standard) 
//			)  
	//=====================================
	//Many employee have one project  
	//cascade: if something happens to the parent entity, the project entity owning entity children go through the same effect
	//=====================================
	
	
	//==========This is FOREIGN KEY================================================
	@ManyToMany(    
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY  
			)  
	@JoinTable(
			name = "project_employee",
			joinColumns = @JoinColumn(name = "employee_id"),
			inverseJoinColumns = @JoinColumn(name="project_id")
			)
	private List<Project> projectRels;  //Project: DataType 
	//==========This is FOREIGN KEY================================================
	
	
//Default CONSTRUCTOR	
	public Employee() {
		
	}
//CONSTRUCTOR		
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
//GETTER AND SETTER
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//ADDITIONALLY AFTER @OneToMany@ManyToOne	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public List<Project> getProjectRels() {
		return projectRels;
	}
	public void setProjectRels(List<Project> projectRels) {
		this.projectRels = projectRels;
	}

	
	

	

}
