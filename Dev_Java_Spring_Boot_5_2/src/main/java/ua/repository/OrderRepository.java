package ua.repository;

import ua.entity.Order;
import ua.entity.Place;
import ua.model.view.MealView;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query("SELECT new ua.model.view.MealView(m.id, m.name, m.fullDescription, m.price, m.weight, c.name) FROM Meal m"
			+ " JOIN m.cuisine c")
	List<MealView> findAllMeals();
	@Query("SELECT new Place(p.number, p.countOfPeople, p.isFree)FROM Place p")
	List<Place> findAllPlaces();

}
