package ua.model.view;

import ua.entity.Place;

public class OrderView {

	private Integer id;
	
	private Place place;

	public OrderView(Integer id, Place place) {
		this.id = id;
		this.place = place;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	
}
