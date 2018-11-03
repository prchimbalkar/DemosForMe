package com.HateOASexample.HATEOASDemo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HateOASexample.HATEOASDemo.DTO.Car;
import com.HateOASexample.HATEOASDemo.DTO.Car.CarColors;

@RestController
@RequestMapping("/api")
public class StandardController {

	@GetMapping(value="/cars", produces=MediaTypes.HAL_JSON_VALUE)
	public List<Car> getAll() {
		
		Car car1 = new Car("Ferrari",CarColors.Red,100);
		Link link = ControllerLinkBuilder.linkTo(StandardController.class).slash(car1.getName()).withSelfRel();
		car1.add(link );
		Car car2 = new Car("Mercedese",CarColors.Yellow,200);
		link = ControllerLinkBuilder.linkTo(StandardController.class).slash(car2.getName()).withSelfRel();
		car2.add(link );
		Car car3 = new Car("BMW",CarColors.Blue,300);
		link = ControllerLinkBuilder.linkTo(StandardController.class).slash(car3.getName()).withSelfRel();
		car3.add(link );
		Car car4 = new Car("Mahindra",CarColors.Green,400);
		link = ControllerLinkBuilder.linkTo(StandardController.class).slash(car4.getName()).withSelfRel();
		car4.add(link );
		
		return Arrays.asList(car1,car2,car3,car4);
	}
	
	@RequestMapping(value="/cars/{cname}")
	public List<Car> getCarByName(@PathVariable("cname") String name){
		
		List<Car> carsList = new ArrayList<>();
		
		Car car1 = new Car("Ferrari",CarColors.Red,100);
		Car car2 = new Car("Mercedese",CarColors.Yellow,200);
		Car car3 = new Car("BMW",CarColors.Green,300);
		Car car4 = new Car("Mahindra",CarColors.Blue,400);

		if("Ferrari".equals(name)) {
			carsList.add(car1);
		}
		if("Mercedese".equals(name)) {
			carsList.add(car2);
		}
		if("BMW".equals(name)) {
			carsList.add(car3);
		}
		if("Mahindra".equals(name)) {
			carsList.add(car4);
		}
		return carsList;
		
	}

	@PostMapping("/cars")
	public String saveAllCars() {
		
	return "msg";
	}
	
	@DeleteMapping("/cars")
	public String deleteCar() {

	return "msg";
	}
	
	
	
}
