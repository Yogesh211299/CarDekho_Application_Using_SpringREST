package com.jspiders.cardekhoapplication_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekhoapplication_rest.pojo.CarPojo;
import com.jspiders.cardekhoapplication_rest.response.CarResponse;
import com.jspiders.cardekhoapplication_rest.service.CarService;

@RestController
public class CarController {
	
	@Autowired
	private CarService service;

	@PostMapping(path="/addCar",consumes = MediaType.APPLICATION_JSON_VALUE,
			      produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<CarResponse> addNewCar(@RequestBody CarPojo carPojo){
		CarPojo car=service.addNewCar(carPojo);
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car Data Added Successfully..!",car,null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car Data not  Added",null,null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
	@PostMapping(path = "/searchCar",
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< CarResponse> searchCar(@RequestParam int id){
		 CarPojo car=service.searchCar(id);
		 if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data found successfully..!",car,null),HttpStatus.FOUND);
		}
		 return new ResponseEntity<CarResponse>(new CarResponse("Data not found",null,null),HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping(path = "/searchAllCars",
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchAllCars(){
		List<CarPojo> cars=service.searchAllCars();
		if (cars != null) {
			
		if (cars.isEmpty()==false) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data found successfully..!",null,cars),HttpStatus.FOUND);
		}
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Data not found ",null,null),HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/deleteCar{id}",
			       produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> deleteCar(@PathVariable int id){
		CarPojo car=service.deleteCar(id);
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car Data deleted successfully..!",car,null),HttpStatus.OK);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car data not exists",null,null),HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(path = "/updateCar",
			    consumes = MediaType.APPLICATION_JSON_VALUE,
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> updateCar(@RequestBody CarPojo carPojo){
	 CarPojo car=service.updateCar(carPojo);
	 if (car != null) {
		return new ResponseEntity<CarResponse>(new CarResponse("Car data updated successfully..!",car,null),HttpStatus.ACCEPTED);
	}
	 return new ResponseEntity<CarResponse>(new CarResponse("Car data not  updated!",null,null),HttpStatus.NOT_ACCEPTABLE);
	}
	
}
