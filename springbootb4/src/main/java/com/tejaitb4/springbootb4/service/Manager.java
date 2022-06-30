package com.tejaitb4.springbootb4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
//@Primary
@Service("manager")
public class Manager implements EmployeeRole {
@Autowired
	@Override
	public String designation() {
		return "Manager";
	}

}
