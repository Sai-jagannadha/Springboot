package com.tejaitb4.springbootb4.FactoryDesignPattern;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.tejaitb4.springbootb4.model.Employee;

public class WordFile implements FileGen{

	@Override
	public void genFile(List<Employee> empList, String folder) throws IOException {
		XWPFDocument document = new XWPFDocument();
		XWPFTable table = document.createTable();
		boolean isFirstime=true;
		for (Employee emp : empList) {
		XWPFTableRow row =null;
		if(isFirstime){
		row = table.getRow(0);
		row.getCell(0).setText(emp.getEid()+"");
		row.addNewTableCell().setText(emp.getFullName()+"");
		row.addNewTableCell().setText(emp.getSalary()+"");
		isFirstime=false;
		}else{
		row=table.createRow();
		row.getCell(0).setText(emp.getEid()+"");
		row.getCell(1).setText(emp.getFullName()+"");
		row.getCell(2).setText(emp.getSalary()+"");
		}

		XWPFParagraph paraGraph = document.createParagraph();
		XWPFRun run = paraGraph.createRun();
		run.setText(emp.getEid()+"::"+emp.getFullName()+"::"+emp.getSalary());
		}

		FileOutputStream wordfos = new FileOutputStream(folder+"employee.docx");
		document.write(wordfos);
		wordfos.close();
	}

}
