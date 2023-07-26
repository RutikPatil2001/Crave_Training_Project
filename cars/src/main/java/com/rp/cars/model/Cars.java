package com.rp.cars.model;

import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cars {
	
	private int carId;
	private String colour;
	private double price;
	private String model;
	
	@Id
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Cars(int carId, String colour, double price, String model) {
		super();
		this.carId = carId;
		this.colour = colour;
		this.price = price;
		this.model = model;
	}
	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", colour=" + colour + ", price=" + price + ", model=" + model + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(colour, carId, model, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cars other = (Cars) obj;
		return Objects.equals(colour, other.colour) && carId == other.carId && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	

}
