package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="_order")
public class Order extends AbstractEntity {
	
	@ManyToMany
	private List<Meal> meals = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Place place;

	public Order(List<Meal> meals, Place place) {
		this.meals = meals;
		this.place = place;
	}

	public Order() {
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	
	
}
