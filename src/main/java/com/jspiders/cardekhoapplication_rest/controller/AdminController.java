package com.jspiders.cardekhoapplication_rest.controller;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekhoapplication_rest.pojo.AdminPojo;
import com.jspiders.cardekhoapplication_rest.response.AdminResponse;
import com.jspiders.cardekhoapplication_rest.service.AdminService;

@RestController
public class AdminController {
 
	@Autowired
	private AdminService service;
	
	
	@PostMapping(path = "/createAdmin",
			     consumes= MediaType.APPLICATION_JSON_VALUE,
			     produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> createAdmin(@RequestBody AdminPojo pojo){
		AdminPojo admin=service.createAdmin(pojo);
		if (admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Account Created successfully..!",admin),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<AdminResponse>(new AdminResponse("Account not created ",null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@PostMapping(path = "/login",
			     consumes= MediaType.APPLICATION_JSON_VALUE,
			     produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> login(@RequestBody AdminPojo pojo){
		AdminPojo admin=service.login(pojo);
		if (admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Login successfully..!",admin),HttpStatus.OK);
		}
		return new ResponseEntity<AdminResponse>(new AdminResponse("Login Failed..!",null),HttpStatus.BAD_REQUEST);		
	}
	
}
