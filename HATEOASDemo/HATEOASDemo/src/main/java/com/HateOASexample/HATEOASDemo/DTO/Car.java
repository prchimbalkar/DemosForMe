package com.HateOASexample.HATEOASDemo.DTO;

import org.springframework.hateoas.ResourceSupport;

public class Car extends ResourceSupport{
	
	public enum CarColors{
		Red,Yellow,Green,Blue
	}

	String companyName;
	CarColors color;
	Integer speed;
	public String getName() {
		return companyName;
	}
	public void setName(String name) {
		this.companyName = name;
	}
	public Car(String name, CarColors color, Integer speed) {
		super();
		this.companyName = name;
		this.color = color;
		this.speed = speed;
	}
	public CarColors getColor() {
		return color;
	}
	public void setColor(CarColors color) {
		this.color = color;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

}
