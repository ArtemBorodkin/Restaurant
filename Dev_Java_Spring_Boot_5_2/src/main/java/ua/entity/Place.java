package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="place")
public class Place extends AbstractEntity {

	private int countOfPeople;
	
	private int number;
	
	private boolean isFree;
	
	public Place(){}
	
	public Place(int number, int countOfPeople, boolean isFree){
		this.number = number;
		this.countOfPeople = countOfPeople;
		this.isFree=isFree;
	}
	
	@OneToMany(mappedBy="place")
	private List<Order> orders = new ArrayList<>();
	
	public List<Order> getOrders(){
		return orders;
	}
	
	public void setOrders(List<Order> orders){
		this.orders = orders;
	}
	public boolean isFree(){
		return isFree;
	}
	
	public void setFree(boolean isFree){
		this.isFree= isFree;
	}
	
	public int getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
