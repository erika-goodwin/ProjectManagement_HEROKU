package com.a0521.pma.entity;

import java.util.ArrayList;
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


@Entity  	//For telling Spring what needs to be saved into the database 
			// => Spring boot will exactly know how to treat this class 
			//  => Creating a table for us in the database with this field
public class Project {

	//==============THIS IS ID================================================
	@Id   											//Under "javax.persistence"
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Under "javax.persistence"
	private long projectId;
	//==============THIS IS ID================================================
	
	private String name;
	private String stage; // INPROGRESS, NOTSTARTED, COMPLETED
	private String description;
	 
//	@OneToMany(mappedBy = "projectRel") 	 //   <==> @ManyToOne in Employee.java
	//@OneToMany Meaning: One project has many employees
	// projectRel (value) = key * rel=relationship
	
	//==========This is FOREIGN KEY================================================
// [[ Annotation for employee List]] 	
	@ManyToMany (         //==> for both way
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY  
			)  
	@JoinTable(
			name= "project_employee", 
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "employee_id")
			)  
	//@JointTable meaning: The annotation where we will specify the name of column. 
	// name: a standard convention when naming your joint table 
	private List<Employee> employees;
	//==========This is FOREIGN KEY================================================
	
	
//DEFAULT CONSTRUCTOR	
	public Project() {
		
	}
//CONSTRUCTOR	
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

//GETTER AND SETTER	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

//ADDITIONALLY AFTER @OneToMany@ManyToOne
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
//Convenience Method >> ProjectManagementApplication.java	
	public void addEmployee(Employee emp) {
		if(employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(emp);
	}
	
	
}
