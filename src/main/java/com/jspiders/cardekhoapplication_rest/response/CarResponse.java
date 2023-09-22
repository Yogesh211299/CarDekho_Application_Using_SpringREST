package com.jspiders.cardekhoapplication_rest.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.cardekhoapplication_rest.pojo.CarPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

	private String msg;
	private CarPojo car;
	private List<CarPojo> cars;
}
