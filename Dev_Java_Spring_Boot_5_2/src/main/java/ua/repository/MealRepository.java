package ua.repository;

import java.util.List;
import ua.entity.Meal;
import ua.model.view.MealView;

import org.springframework.data.jpa.repository.Query;

public interface MealRepository extends JpaNameRepository<Meal>{
	
	@Query("SELECT c.name FROM Cuisine c")
	List<String> findAllCuisines();
	
	@Query("SELECT new ua.model.view.ComponentView(c.id, i.name, c.amount, ms.name)FROM Component c JOIN c.ingredient i JOIN c.ms ms")
	List<String> findAllComponents();
	
	@Query("SELECT new ua.model.view.MealView(m.id, m.name, m.fullDescription, m.price, m.weight, c.name)"
			+ " FROM Meal m JOIN m.cuisine c")
	List<MealView> findAllView();
	
	@Query("SELECT m FROM Meal m JOIN FETCH m.cuisine WHERE m.id=?1")
	Meal findOneRequest(Integer id);
}
