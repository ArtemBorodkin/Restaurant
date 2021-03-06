package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="component")
public class Component extends AbstractEntity{

	public Component(Ingredient ingredient, BigDecimal amount, Ms ms) {
		this.ingredient = ingredient;
		this.amount = amount;
		this.ms = ms;
	}
	
	public Component(){}

	@ManyToOne(fetch=FetchType.LAZY)
	private Ingredient ingredient;
	
	private BigDecimal amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Ms ms;

	@ManyToMany(mappedBy="components") 
	private List<Meal> meals = new ArrayList<>();
	
	public List<Meal> getMeals(){
		return meals;
	}
	public void setMeals(List<Meal> meals){
		this.meals = meals;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Ms getMs() {
		return ms;
	}

	public void setMs(Ms ms) {
		this.ms = ms;
	}
	
	
}
