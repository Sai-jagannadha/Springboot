package com.tejaitb4.springbootb4.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tejaitb4.springbootb4.FactoryDesignPattern.FactoryDesign;
import com.tejaitb4.springbootb4.GlobalException.UserNotFoundException;
import com.tejaitb4.springbootb4.model.ApiResponse;
import com.tejaitb4.springbootb4.model.Employee;
import com.tejaitb4.springbootb4.service.EmployeeService;
@RestController
@RequestMapping("/emp") //class level name

public class EmployeeController {
@Autowired
	EmployeeService service;

@RequestMapping(value="/saveEmp",method=RequestMethod.POST) //saveEmp is method level
public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee){	

Employee emp=service.saveEmployee(employee);
//employee.getSalary()
	ResponseEntity<Employee> re=new ResponseEntity<Employee>(emp,HttpStatus.OK);
	return re;
}

@RequestMapping(value="/updateEmp",method=RequestMethod.PUT) 
public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee){	

Employee emp=service.saveEmployee(employee);
	ResponseEntity<Employee> re=new ResponseEntity<Employee>(emp,HttpStatus.OK);
	return re;
}
@RequestMapping(value="/getByEmpId/{eid}",method=RequestMethod.GET)
public Optional<Employee> getByEmpId(@PathVariable Integer eid) throws Exception{
	Optional<Employee> optEmp=service.getEmployee(eid);
	optEmp.orElseThrow(()-> new Exception("data not found"));
	return optEmp;
	
}
@GetMapping("/getAllEmps")
public ResponseEntity<List<Employee>> getAllEmps(@RequestBody Employee employee){
	List<Employee> list=service.getAllEmployees();
	return new ResponseEntity<>(list,HttpStatus.OK);
	
}
@DeleteMapping("/delById/{eid}")
public ResponseEntity<String> delByEmpId(@PathVariable Integer eid){
service.DelById(eid);
return new ResponseEntity<>("deleted successfully id"+eid, HttpStatus.OK);

	
}
@GetMapping("salaryLessThan/{salary}")
public ResponseEntity<List<Employee>> findBySalaryLessThan(@PathVariable Long salary){
	List<Employee> list=service.getEmployeeLessThanSalary(salary);
	return new ResponseEntity<>(list, HttpStatus.OK);
}
@GetMapping("/findByDepartment/{dept}")
public ResponseEntity<List<Employee>> findByDepartment(@PathVariable String dept){
	List<Employee> list=service.getEmployeeDepartment(dept);
	return new ResponseEntity<>(list, HttpStatus.OK);

}


@GetMapping("/findBySalaryGreaterThan/{salary}")
public ResponseEntity<List<Employee>> findBySalaryGreaterThan(@PathVariable Long salary){
	List<Employee> list=service.getEmployeeGreaterThanSalary(salary);
	return new ResponseEntity<>(list, HttpStatus.OK);

}
@GetMapping("/findByFnameStartingWith/{fname}")
public ResponseEntity<List<Employee>>findByFnameStartingWith(@PathVariable String fname){
	List<Employee> list=service.getEmployeeByFnameStartingWith(fname);
	
	return new ResponseEntity<>(list, HttpStatus.OK);
}
@GetMapping("/findByFnameEndingWith/{fname}")
public ResponseEntity<List<Employee>>findByFnameEndingWith(@PathVariable String fname){
	List<Employee> list=service.getEmployeeByFnameEndingWith(fname);
	
	return new ResponseEntity<>(list, HttpStatus.OK);
}

@GetMapping("/findByFirstnameContaining/{fname}")
public ResponseEntity<List<Employee>>findByFirstnameContaining(@PathVariable String fname){
	List<Employee> list=service.getEmployeeByFnameContains(fname);
	return new ResponseEntity<>(list, HttpStatus.OK);
}
@GetMapping("/findByDistinctAge/{age}")
public ResponseEntity<List<Employee>>findByDistinctAge(@PathVariable Integer age){
	List<Employee> list=service.getEmployeeByDistinctAge(age);
	return new ResponseEntity<>(list, HttpStatus.OK);

}
@GetMapping("/GreaterThanEqual/{salary}")
public ResponseEntity<List<Employee>>GreaterThanEqual(@PathVariable Long salary){
	List<Employee> list=service.getEmployeeByGreaterThanEqual(salary);
	return new ResponseEntity<>(list, HttpStatus.OK);

}
@GetMapping("/findByLnameAndFname/{fname}/{lname}")
public ResponseEntity<List<Employee>>findByLnameAndFname(@PathVariable String fname, @PathVariable String lname){
	List<Employee> list=service.getEmployeeByAnd(fname,lname);
	return new ResponseEntity<>(list, HttpStatus.OK);

}
@GetMapping("/findByAgeOrderByageDesc/{age}")
public ResponseEntity<List<Employee>> findByAgeOrderByageDesc(@PathVariable Integer age){
	List<Employee> list= service.getEmployeeByAgeOrderByAgeDesc(age );
	return new ResponseEntity<>(list, HttpStatus.OK);
}

@GetMapping("/findBylike/{fname}")
public ResponseEntity<List<Employee>>findByFnameLike(@PathVariable  String fname ){
	List<Employee> list=service.getEmployeeeFnameLike(fname);
	return new ResponseEntity<>(list, HttpStatus.OK);

}
@GetMapping("/findByEquals/{fname}")
public ResponseEntity<List<Employee>>findByFnameEquals(@PathVariable  String fname ){
	List<Employee> list=service.getEmployeeeFnameEquals(fname);
	return new ResponseEntity<>(list, HttpStatus.OK);

}
@GetMapping("/findByNotLike/{fname}")
public ResponseEntity<List<Employee>>findByFnameNotLike(@PathVariable  String fname ){
	List<Employee> list=service.getEmployeeeFnameNotLike(fname);
	return new ResponseEntity<>(list, HttpStatus.OK);

}
@GetMapping("/findByNotContains/{fname}")
public ResponseEntity<List<Employee>>findByFnameNotContaining(@PathVariable  String fname ){
	List<Employee> list=service.getEmployeeeFnameNotContains(fname);
	return new ResponseEntity<>(list, HttpStatus.OK);

}
@GetMapping("/pagination")
public Page<Employee> pagination(@RequestParam Integer pageNum, @RequestParam Integer pagesize){
Page<Employee>	pagedata=service.paginationOfEmployees(pageNum,pagesize);
return pagedata;
}
@GetMapping("/search")
public ResponseEntity<List<Employee>>search(@RequestParam String input){
List<Employee> list=service.searchingEmployeeData(input);
return  new ResponseEntity<>(list,HttpStatus.OK);
}

@GetMapping("/userAvailability")
public ResponseEntity<Boolean> userAvailability(@RequestParam String username) {
	Boolean result=service.userAvailability(username);
	if (result==false) {
		throw new UserNotFoundException();
	}
	return new ResponseEntity<>(result, HttpStatus.OK); 
}
@GetMapping("/filters")
public ResponseEntity<List<Employee>>empDataWithFilters(@RequestParam String filter,@RequestParam String empcode){
	List<Employee> list=service.EmpfilterData(filter, empcode);
	return new ResponseEntity<>( list,HttpStatus.ACCEPTED);
	
}
@GetMapping("/factoryDesign/{fileTypes}")
public ResponseEntity<String>factoryDesignPattern(@PathVariable String fileTypes) throws IOException{
	String folder="C:\\factory\\";
	List<Employee>list=service.getAllEmployees();
	FactoryDesign fd=new FactoryDesign(fileTypes);
	fd.executeInputFiles(list
			, folder);
	return new ResponseEntity<String>("Files Created Successfully", HttpStatus.OK);
}
@GetMapping("/bulderDesign")
public ResponseEntity<ApiResponse> builderDesign(@RequestHeader HttpHeaders headers){
	System.out.println("headers are "+headers);
	List<Employee>data=service.getAllEmployees();
	return service.findAllBuilderDesign(headers, data);
}



@Bean
public RestTemplate restTemplate() {
	return new RestTemplate();
}



@GetMapping("/rest")
public ResponseEntity<String> restTemplateExample(){
	RestTemplate restTemplate=new RestTemplate();
	String data=restTemplate.getForObject("http://localhost:8082/restTemplate/test",String.class );
	return new ResponseEntity<String>("success"+data,HttpStatus.OK);
}

}
