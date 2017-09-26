package ua.repository;

import java.util.List;
import ua.entity.Cuisine;
import ua.model.view.CuisineView;

import org.springframework.data.jpa.repository.Query;

public interface CuisineRepository extends JpaNameRepository<Cuisine>{

	@Query("SELECT  new ua.model.view.CuisineView(c.id, c.name) FROM Cuisine c")
	List<CuisineView> findAllView();
	
	@Query("SELECT c.name FROM Cuisine c")
	List<String> findAllCuisines();
	
	
}
