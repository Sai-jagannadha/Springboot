package com.tejaitb4.springbootb4.FactoryDesignPattern;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import com.tejaitb4.springbootb4.model.Employee;

public class FactoryDesign {
	List<FileGen> listFileInputs=new ArrayList<>();
	// String types="txt,pdf,xlsx,docx";
public FactoryDesign(String types) {
	String[]filesTypes=types.split(",");
	for (String file : filesTypes) {
		
		FileGen fileGen=FileGenUtil.fileGeneration(file);// created objects for types
		listFileInputs.add(fileGen);
	}
}
public void executeInputFiles(List<Employee> empList,String folder) throws IOException {
	
	for (FileGen fileType: listFileInputs) {
		fileType.genFile(empList,folder);
	}
}

}
