package dao;

import java.util.List;

import domain.Mountain;

public interface MountainDao {

	List <Mountain> findAll() throws Exception;
	
	Mountain findById(Integer id) throws Exception;
	
	Mountain findByName(String name) throws Exception;
	
	void insert (Mountain mountain) throws Exception;
	
	void update (Mountain mountain) throws Exception;
	
	void delete (Mountain mountain) throws Exception;
	
	List<Mountain> findByErea(String erea,String elevation)throws Exception;
	
	List<Mountain> sortAll(String elevation)throws Exception;
}
