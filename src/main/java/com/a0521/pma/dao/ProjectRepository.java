package com.a0521.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.a0521.pma.dto.ChartData;
import com.a0521.pma.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
//	CrudRepository<T, ID> is from springframework.data.repository
//	T:	DataType of this project -> Project
//	ID:	DataType of ID -> Long
//	
//	========From Project.java======THIS IS ID==========
//	@Id   											
//	@GeneratedValue(strategy = GenerationType.AUTO) 
//	private long projectId;
//	==============THIS IS ID===========================
	
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value="SELECT stage as label, COUNT(*) as value "
			+ "FROM project "
			+ "GROUP BY stage")
	public List<ChartData> getProjectStatus(); 
}
