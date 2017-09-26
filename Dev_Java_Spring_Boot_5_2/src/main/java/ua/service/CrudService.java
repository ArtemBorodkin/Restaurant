package ua.service;

import java.util.List;
import java.io.Serializable;

public interface CrudService<T, ID extends Serializable> {

	T findOne(ID id);
	
	List<T> findAll();
	
	void save(T entity);
	
	void delete(ID id);
}
