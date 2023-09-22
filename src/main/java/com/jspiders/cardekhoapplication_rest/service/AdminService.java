package com.jspiders.cardekhoapplication_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhoapplication_rest.pojo.AdminPojo;
import com.jspiders.cardekhoapplication_rest.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public AdminPojo createAdmin(AdminPojo pojo) {
		try {
			AdminPojo admin= repository.createAdmin(pojo);
			return admin;
		} catch (Exception e) {
		return null;	
		}
		
	}

	public AdminPojo login(AdminPojo pojo) {
		AdminPojo admin=repository.login(pojo);
		return admin;
	}
}
