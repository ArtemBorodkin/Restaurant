package ua.service.impl;

import ua.entity.Order;
import ua.entity.Place;
import ua.model.view.MealView;
import ua.service.OrderService;
import ua.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Integer> implements OrderService{

	private final OrderRepository repository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository repository){
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<MealView> findAllMeals() {
		
		return repository.findAllMeals();
	}

	@Override
	public List<Place> findAllPlaces() {
		
		return repository.findAllPlaces() ;
	}
}
