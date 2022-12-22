package dao;

import java.util.List;

import domain.Report;

public interface ReportDao {
		
List <Report> findAll() throws Exception;
	
	Report findById(Integer id) throws Exception;
	
	void insert (Report report) throws Exception;
	
	void update (Report report) throws Exception;
	
	void delete (Integer id) throws Exception;
	
	List <Report> findByReportId(String reportId) throws Exception;
}
