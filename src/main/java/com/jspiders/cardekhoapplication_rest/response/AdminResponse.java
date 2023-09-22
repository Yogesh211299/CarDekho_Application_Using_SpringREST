package com.jspiders.cardekhoapplication_rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.cardekhoapplication_rest.pojo.AdminPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponse {

	private String msg;
	private AdminPojo admin;
}
