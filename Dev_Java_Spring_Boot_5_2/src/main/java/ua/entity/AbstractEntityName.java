package ua.entity;

import ua.validation.flag.*;
import ua.validation.annotation.*;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity{

	@NotBlank(message="This field should not be empty", groups={IngredientFlag.class, CuisineFlag.class})
	@Pattern(regexp="^[A-Z][A-Za-z0-9]+| *$", message="Title must begin from big letter", groups={IngredientFlag.class, CuisineFlag.class})
	@UniqueIngredient(message="This ingredient already exists", groups = IngredientFlag.class)
	@UniqueCuisine(message="This cuisine already exists", groups = CuisineFlag.class)
	private String name;
	
	public AbstractEntityName(String name){
		this.name = name;
	}
	
	public AbstractEntityName(){}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
}
