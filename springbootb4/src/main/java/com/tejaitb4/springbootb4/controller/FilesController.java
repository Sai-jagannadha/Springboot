package com.tejaitb4.springbootb4.controller;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.InputStreamResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.tejaitb4.springbootb4.model.Employee;
import com.tejaitb4.springbootb4.service.EmployeeService;




@RequestMapping("/files")
@RestController
public class FilesController {
	@Autowired
	 EmployeeService service;
	
	@PostMapping("/upload") 
	  public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {

	    String fileName = file.getOriginalFilename();
	    try {
	      file.transferTo( new File("C:\\saijagannadha\\" + fileName));
	    } catch (Exception e) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	    return ResponseEntity.ok("File uploaded successfully.");
	  }
                             //*******downloading************//
	

	@RequestMapping(value = "/download/{filename}", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile(@PathVariable String filename) throws IOException
    {
    String path = "C:\\saijagannadha\\";
    String fileData=path+filename;
    File file = new File(fileData);
    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition",
    String.format("attachment; filename=\"%s\"", file.getName()));
    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
    headers.add("Pragma", "no-cache");
    headers.add("Expires", "0");



    ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
    .contentLength(file.length())
    .contentType(MediaType.parseMediaType("application/txt")).body(resource);



    return responseEntity;
    }
	              //**************Pdf************//
	@GetMapping("/pdf/employees")
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
        try {
                  //Create Document instance.
           Document document = new Document();

           //Create OutputStream instance.
           FileOutputStream outputStream =
               new FileOutputStream(new File("C://saijagannadha//EmployeeData.pdf"));

           //Create PDFWriter instance.
               PdfWriter.getInstance(document, outputStream);

               //Open the document.
               document.open();

               //Add content to the document.
               List<Employee> list=service.getAllEmployees();

               for (Employee employee : list) {
             document.add(new Paragraph(employee.getEmpCode() +"  "+employee.getFullName()+"  "+employee.getSalary()));  
               }

               //Close document and outputStream.
               document.close();
               outputStream.close();

               System.out.println("Pdf created successfully.");
           } catch (Exception e) {
           e.printStackTrace();
           }
         }  
                                    //*****************excel********************//
	
	@CrossOrigin("http://localhost:8080")
	  @Controller
	  @RequestMapping("/api/excel")
	  public class ExcelController {
	    @Autowired
	    EmployeeService empService;
	    @GetMapping("C://saijagannadha")
	    public ResponseEntity<Employee> getFile() {
	      String filename = "employee.xlsx";
	      InputStreamResource file = new InputStreamResource((InputStream) empService.getAllEmployees());
	      return (ResponseEntity<Employee>) ResponseEntity.ok();
	          
	    }
	  }

	       
	}
