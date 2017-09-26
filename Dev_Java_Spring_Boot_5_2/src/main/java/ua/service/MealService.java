package ua.service;

import java.util.List;

import ua.model.view.MealView;
import ua.model.request.MealRequest;


public interface MealService {
	
	List<String> findAllCuisines();
	
	List<String> findAllComponents();
	
	List<MealView> findAllView();
	
	MealRequest findOneRequest(Integer id);
	
	void save(MealRequest request);
	
	void delete(Integer id);

}
