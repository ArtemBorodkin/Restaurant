package ua.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="meal")
public class Meal extends AbstractEntityName{
	
	private String photoUrl;

	private int version;

	private BigDecimal rate;

	private String fullDescription;
	
	private String shortDescription;
	
	private BigDecimal price;
	
	private int weight;
	
	public Meal(String name, String fullDescription, String shortDescription,
			BigDecimal price, int weight, Cuisine cuisine, List<Component> components){
		super(name);
		this.fullDescription = fullDescription;
		this.shortDescription = shortDescription;
		this.price = price;
		this.weight = weight;
		this.cuisine = cuisine;
		this.components = components;
	}
	
	public Meal(){}
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cuisine cuisine;
	
	@ManyToMany(mappedBy="meals")
	private List<Order> orders = new ArrayList<>();
	
	@ManyToMany
	private List<Component> components = new ArrayList<>();
	
	public List<Component> getComponents() {
		return components;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public String getFullDescription() {
		return fullDescription;
	}
	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Cuisine getCuisine() {
		return cuisine;
	}
	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	
}
