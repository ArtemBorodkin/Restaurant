package ua.repository;

import java.util.List;
import ua.entity.Ingredient;
import ua.model.view.IngredientView;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IngredientRepository extends JpaNameRepository<Ingredient>, JpaSpecificationExecutor<Ingredient>{

	@Query("SELECT new ua.model.view.IngredientView(i.id, i.name) FROM Ingredient i")
	List<IngredientView> findAllView();
	
}
