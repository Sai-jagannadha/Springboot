package com.tejaitb4.springbootb4.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("teamlead")
public class TeamLead implements EmployeeRole{
@Autowired
	@Override
	public String designation() {
		
		return "Teamlead";
	}

}