package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="ms")
public class Ms extends AbstractEntityName {
	
	public Ms(){}
	
	public Ms(String name){
		super(name);
	}
	
	@OneToMany(mappedBy="ms")
	private List<Component> components = new ArrayList<>();

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	
}
