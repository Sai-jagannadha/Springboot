package com.tejaitb4.springbootb4.FactoryDesignPattern;

public class FileGenUtil {
public static FileGen fileGeneration(String types) {
	FileGen fileGen=null;
	
	switch (types) {
	case "txt":
		fileGen=new TextFile();
		break;
	case "pdf":
		fileGen=new PdfFile();
		break;
	case "xlsx":
	fileGen=new ExcelFile();
	break;
	case "docx":
	fileGen=new WordFile();
	break;
	}
	return fileGen;
}
}
