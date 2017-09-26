package ua.repository;

import java.math.BigDecimal;
import java.util.List;
import ua.entity.Component;
import ua.model.view.ComponentView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Integer> {

	@Query("SELECT i.name FROM Ingredient i")
	List<String> findAllIngredients();
	@Query("SELECT ms.name FROM Ms ms")
	List<String> findAllMss();
	@Query("SELECT new ua.model.view.ComponentView(c.id, i.name, c.amount, ms.name) FROM Component c JOIN c.ingredient i JOIN c.ms ms")
	List<ComponentView> findAllView();
	@Query("SELECT c FROM Component c JOIN FETCH c.ingredient JOIN FETCH c.ms WHERE c.id=?1")
	Component findOneRequest(Integer id);
	@Query("SELECT c FROM Component c JOIN FETCH c.ingredient i JOIN FETCH c.ms ms WHERE i.name=?1 AND ms.name=?2 AND c.amount=?3")
	Component existsComponent(String ingredient, String ms, BigDecimal amount);


}
