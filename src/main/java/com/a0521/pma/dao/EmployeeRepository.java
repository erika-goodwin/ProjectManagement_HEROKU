package com.a0521.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.a0521.pma.dto.EmployeeProject;
import com.a0521.pma.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();
	
	
	//604 custom query
	@Query(
			nativeQuery = true, 
			value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount\n"
					+ "FROM employee e LEFT JOIN project_employee pe ON e.employee_id=pe.employee_id\n"
					+ "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC"
			)
	public List<EmployeeProject> employeeProject();
}