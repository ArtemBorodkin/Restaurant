package ua.model.request;

import ua.entity.Component;
import ua.entity.Cuisine;
import ua.validation.annotation.UniqueMeal;
import ua.validation.flag.MealFlag;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class MealRequest {
	
	@NotBlank(message="This field should not be empty", groups=MealFlag.class)
	@UniqueMeal(message="This not unique name",groups=MealFlag.class)
	private String name;
	
	private Integer id;

	private String photoUrl;

	private int version;

	private String rate;
	@NotBlank(message="This field should not be empty", groups=MealFlag.class)
	private String fullDescription;
	@NotBlank(message="This field should not be empty", groups=MealFlag.class)
	private String shortDescription;
	@NotBlank(message="This field should not be empty", groups=MealFlag.class)
	@Pattern(regexp="^(?=.*?\\d).{2,5}+| *$", message="Only numbers (max 5)",groups=MealFlag.class)
	private String price;
	@NotBlank(message="This field should not be empty", groups=MealFlag.class)
	@Pattern(regexp="^[0-9].{4}+[0-9].{2}+[0-9].{2}+| *$", message="for instance 2017.09.07",groups=MealFlag.class)
	private String weight;
	
	private Cuisine cuisine;
	
	private List<Component> components = new ArrayList<>();

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}
	
	
}
