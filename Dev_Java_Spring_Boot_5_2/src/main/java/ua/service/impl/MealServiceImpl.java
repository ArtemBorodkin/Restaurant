package ua.service.impl;

import ua.entity.Meal;
import ua.model.request.MealRequest;
import ua.model.view.MealView;
import ua.service.MealService;
import ua.repository.MealRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MealServiceImpl implements MealService{
	
	private final MealRepository repository;

	@Autowired
	public MealServiceImpl(MealRepository repository){
		this.repository=repository;
	}

	@Override
	public List<String> findAllCuisines() {
		return repository.findAllCuisines();
	}

	@Override
	public List<String> findAllComponents() {
		return repository.findAllComponents();
	}

	@Override
	public List<MealView> findAllView() {
		return repository.findAllView();
	}

	@Override
	public MealRequest findOneRequest(Integer id) {
		Meal meal = repository.findOneRequest(id);
		MealRequest request = new MealRequest();
		request.setId(meal.getId());
		request.setName(meal.getName());
		request.setCuisine(meal.getCuisine());
		request.setFullDescription(meal.getFullDescription());
		request.setShortDescription(meal.getShortDescription());
		request.setPrice(meal.getPrice().toString());
		request.setWeight(String.valueOf(meal.getWeight()));
		request.setComponents(meal.getComponents());
		return request;
	}

	@Override
	public void save(MealRequest request) {
		Meal meal = new Meal();
		meal.setId(request.getId());
		meal.setName(request.getName());
		meal.setCuisine(request.getCuisine());
		meal.setFullDescription(request.getFullDescription());
		meal.setShortDescription(request.getShortDescription());
		meal.setPrice(new BigDecimal(request.getPrice()));
		meal.setWeight(new Integer(request.getWeight()));
		meal.setComponents(request.getComponents());
		repository.save(meal);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
		
	}
}
