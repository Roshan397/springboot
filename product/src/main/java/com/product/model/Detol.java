package com.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Detol {
	@Id
	private int batno;
	private String type; 
	private String manarea;
	private int cost;
	private String shipping;
	private String packing;
	private String delivery;
	private int scharge;
	private int dcharge;
	public String getShipping() {
		return shipping;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public int getScharge() {
		return scharge;
	}
	public void setScharge(int scharge) {
		this.scharge = scharge;
	}
	public int getDcharge() {
		return dcharge;
	}
	public void setDcharge(int dcharge) {
		this.dcharge = dcharge;
	}
	public int getBatno() {
		return batno;
	}
	public void setBatno(int batno) {
		this.batno = batno;
	}
	public String getManarea() {
		return manarea;
	}
	public void setManarea(String manarea) {
		this.manarea = manarea;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

}
