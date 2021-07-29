package com.a0521.pma.controllers;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.a0521.pma.dao.EmployeeRepository;
import com.a0521.pma.dao.ProjectRepository;
import com.a0521.pma.dto.ChartData;
import com.a0521.pma.dto.EmployeeProject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@Controller
public class HomeController {

//700	
	@Value("${version}")
	private String ver;

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		List<EmployeeProject> employeesProjCount = empRepo.employeeProject();
		model.addAttribute("employeeList", employeesProjCount);
	
//700		
//		System.out.println("message from value: " +ver);
		model.addAttribute("versionNumber", ver);
		
//604		
		List<ChartData> projectData = proRepo.getProjectStatus();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		// [[label:"NOTSTARTED", value:1], ["INPROGRESS",2],["COMPLETED",3]]
		model.addAttribute("projectStatusCount", jsonString);
		 
		return "main/home";
	}

}
