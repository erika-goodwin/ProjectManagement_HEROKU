package com.a0521.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.a0521.pma.dao.EmployeeRepository;
import com.a0521.pma.dao.ProjectRepository;
import com.a0521.pma.entity.Employee;
import com.a0521.pma.entity.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired //Annotation for automatically creating (injecting) instance of project repository 
	ProjectRepository proRepo;
	
	
	//For communicate with the employee table
	@Autowired
	EmployeeRepository empRepo;
	

	@GetMapping //directory shows this
	public String displayProjects(Model model) { //Model (parameter): binds the data from Java to HTML
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectList", projects); //("KeyName", Object) "KeyName" will be used in HTML for connecting. 
		return "projects/list-projects";
	}
	
//	@RequestMapping("/new")
	@GetMapping("/new") //annotation for getting
	public String displayProjectForm(Model model) {
		
		//==FOR adding Employee ==
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeeList", employees);
		
		model.addAttribute("project", new Project());
		return "projects/new-project";
	}
	
//	@RequestMapping(value="/save", method = RequestMethod.POST)  ||Parameterized Request Mapping||
	@PostMapping("/save")  //annotation 
	public String createProject(Project project, Model model) {
		//this should handle saving to the database
		proRepo.save(project); //saving the data into the database
		
//=================================================================		
//We do not need to do a foreign key association anymore 
//No need to this ↓↓↓↓↓↓↓↓	
		 
//		Iterable<Employee> chosenEmployee = empRepo.findAllById(employees);
//		for(Employee emp : chosenEmployee) {
//			emp.setProjectRel(project);   //FOREIGN KEY from employee.java   //Setting
//			empRepo.save(emp); //Setting then saving 
//			
//		}
//And changed this argument too  ↓↓↓↓↓↓↓↓			
//		public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
//=================================================================			
		
		return "redirect:/projects";
	}
}
