package ua.model.request;

import ua.entity.Ms;
import javax.validation.constraints.Pattern;
import ua.validation.annotation.UniqueComponent;
import org.hibernate.validator.constraints.NotBlank;

import ua.entity.Ingredient;

@UniqueComponent
public class ComponentRequest {
	
	private Integer id;
	
	private Ingredient ingredient;
	@NotBlank(message="Can not be empty")
	@Pattern(regexp = "^(?=.*?\\d).{2,3}+| *$", message="Only numbers (max 3)")
	private String amount;
	
	private Ms ms;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Ingredient getIngredient(){
		return ingredient;
	}
	
	public void setIngredient(Ingredient ingredient){
		this.ingredient = ingredient;
	}
	
	public String getAmount(){
		return amount;
	}
	
	public void setAmount(String amount){
		this.amount = amount;
	}
	
	public Ms getMs(){
		return ms;
	}
	
	public void setMs(Ms ms){
		this.ms = ms;
	}	

}
