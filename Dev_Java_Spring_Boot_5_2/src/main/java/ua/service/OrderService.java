package ua.service;

import java.util.List;

import ua.entity.Order;
import ua.entity.Place;
import ua.model.view.MealView;

public interface OrderService extends CrudService<Order, Integer>{

	List<MealView> findAllMeals();
	
	List<Place> findAllPlaces();

}
