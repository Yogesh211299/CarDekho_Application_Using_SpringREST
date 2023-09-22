package com.jspiders.cardekhoapplication_rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekhoapplication_rest.pojo.CarPojo;

@Repository
public class CarRepositroy {

	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	public static void openConnection() {
		factory=Persistence.createEntityManagerFactory("CarDekho");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
	}
	 
	public static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	

	public CarPojo addNewCar(CarPojo carPojo) {
      openConnection();
      transaction.begin();
      
      manager.persist(carPojo);
      
      transaction.commit();
      closeConnection();
		return carPojo;
	}

	public CarPojo searchCar(int id) {
       openConnection();
       transaction.begin();
       
       CarPojo car=manager.find(CarPojo.class,id);
       
       transaction.commit();
       closeConnection();
		return car;
	}

	public List<CarPojo> searchAllCars() {
      openConnection();
      transaction.begin();
      
      String findCars="from CarPojo";
      query=manager.createQuery(findCars);
      List<CarPojo> cars=query.getResultList();
      
      if (cars != null) {
		
     if (cars.isEmpty()==false) {
		transaction.commit();
		closeConnection();
		return cars;
	}
      }
      transaction.commit();
      closeConnection();
		return null;
	}

	public CarPojo deleteCar(int id) {
    openConnection();
    transaction.begin();
    
    CarPojo car=manager.find(CarPojo.class,id);
    if (car != null ) {
		manager.remove(car);
		transaction.commit();
		closeConnection();
		return car;
	}
    transaction.commit();
    closeConnection();
		return null;
	}

	public CarPojo updateCar(CarPojo carPojo) {
      openConnection();
      transaction.begin();
      
      CarPojo car=manager.find(CarPojo.class,carPojo.getId());
      
      if (car != null) {
		car.setName(carPojo.getName());
		car.setBrand(carPojo.getBrand());
		car.setFuelType(carPojo.getFuelType());
		car.setModel(carPojo.getModel());
		car.setPrice(carPojo.getPrice());
		transaction.commit();
		closeConnection();
		return car;
	}
      transaction.commit();
      closeConnection();
		return null;
	}

}
