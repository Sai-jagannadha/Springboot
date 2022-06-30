package com.tejaitb4.springbootb4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejaitb4.springbootb4.service.EmployeeRole;

@RestController("/qualifier")
public class QualifierController {
@Autowired
@Qualifier("teamlead")
	EmployeeRole roleservice;
	@GetMapping("/empRole")
	public String employeeRole() {
		String designation=roleservice.designation();
		return designation;
	}
}
