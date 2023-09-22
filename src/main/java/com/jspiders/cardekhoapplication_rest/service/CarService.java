package com.jspiders.cardekhoapplication_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhoapplication_rest.pojo.CarPojo;
import com.jspiders.cardekhoapplication_rest.repository.CarRepositroy;

@Service
public class CarService {

	@Autowired
	private CarRepositroy repositroy;
	
	public CarPojo addNewCar(CarPojo carPojo) {
		CarPojo car=repositroy.addNewCar(carPojo);
		return car;
	}

	public CarPojo searchCar(int id) {
      CarPojo car=repositroy.searchCar(id);
		return car;
	}

	public List<CarPojo> searchAllCars() {
      List<CarPojo> cars=repositroy.searchAllCars();
		return cars;
	}

	public CarPojo deleteCar(int id) {
    CarPojo car=repositroy.deleteCar(id);
		return car;
	}

	public CarPojo updateCar(CarPojo carPojo) {
    CarPojo car=repositroy.updateCar(carPojo);
		return car;
	}

}
