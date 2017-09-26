package ua.entity;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Table(name="Ingredient", indexes=@Index(columnList="name", unique=true))
public class Ingredient extends AbstractEntityName{
	
	public Ingredient(){
	}
	
	public Ingredient(String name){
		super(name);
	}

	@OneToMany(mappedBy="ingredient")
	private List<Component> components = new ArrayList<>();

	public List<Component> getComponenets() {
		return components;
	}

	public void setComponenets(List<Component> components) {
		this.components = components;
	}
	
	

}
