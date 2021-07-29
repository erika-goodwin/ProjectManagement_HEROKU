package com.a0521.pma;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.a0521.pma.dao.EmployeeRepository;
import com.a0521.pma.dao.ProjectRepository;


//This is the first file executed when we run the project
//-> automation of populating (adding) the list refer to the repository
//-> import our entities
//-> create an instance or new object of employee
//-> save it on the database

// ↑↑↑ We can do it here ↑↑↑
// ↓↓↓ For that, adding implements and more  ↓↓↓


@SpringBootApplication
public class ProjectManagementApplication{

//@SpringBootApplication
//public class ProjectManagementApplication implements CommandLineRunner{
	//implements CommandLineRunner: Allow us to e able to add an unimplemented method which is the run
	
	
	
	
//Object for allowing us to communicate with the database  	
	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	ProjectRepository proRepo;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
//
//
////Added from commandLineRunner [auto fill]
//	@Override
//	public void run(String... args) throws Exception {
//		Employee emp1 = new Employee("Hoge1", "Hoge1", "hogehoge1@hoge.com");
//		Employee emp2 = new Employee("Hoge2", "Hoge2", "hogehoge2@hoge.com");
//		Employee emp3 = new Employee("Hoge3", "Hoge3", "hogehoge3@hoge.com");
//		
//		Project proj1 = new Project("Project hoge hoge 1", "NONSTARTED", "description 1");
//		Project proj2 = new Project("Project hoge hoge 2", "COMPLETED", "description 2");
//		Project proj3 = new Project("Project hoge hoge 3", "IMPROGRESS", "description 3");
//		
//		//Set both sides of the relationship manually
//		//[Project side of relationship]
//		proj1.addEmployee(emp1);
//		proj1.addEmployee(emp2);
//		proj2.addEmployee(emp1);
//		proj2.addEmployee(emp3);
//		proj3.addEmployee(emp2);
//		proj3.addEmployee(emp3);
//		
//		//[Employee side of relationship]
//		emp1.setProjectRels(Arrays.asList(proj1,proj2,proj3));
//		emp2.setProjectRels(Arrays.asList(proj1,proj3));
//		emp3.setProjectRels(Arrays.asList(proj3));
//		
//		//Save to database
//		empRepo.save(emp1);
//		empRepo.save(emp2);
//		empRepo.save(emp3);
//		
//		proRepo.save(proj1);
//		proRepo.save(proj2);
//		proRepo.save(proj3);
//	}





}
