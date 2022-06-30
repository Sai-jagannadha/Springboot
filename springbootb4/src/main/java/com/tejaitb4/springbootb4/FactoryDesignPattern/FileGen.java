package com.tejaitb4.springbootb4.FactoryDesignPattern;

import java.io.IOException;
import java.util.List;

import com.tejaitb4.springbootb4.model.Employee;

public interface FileGen {
	public void genFile(List<Employee> empList, String folder) throws IOException;
}
