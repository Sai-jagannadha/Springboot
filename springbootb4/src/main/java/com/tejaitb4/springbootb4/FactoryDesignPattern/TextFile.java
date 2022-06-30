package com.tejaitb4.springbootb4.FactoryDesignPattern;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.tejaitb4.springbootb4.model.Employee;


public class TextFile implements FileGen{

	@Override
	public void genFile(List<Employee> empList, String folder) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(folder+"employee.txt"));

		for(Employee emp:empList) {
		writer.write(emp.getEid()+" "+emp.getFullName()+" "+emp.getSalary());
		writer.newLine();
		}
		writer.close();
	}

}
