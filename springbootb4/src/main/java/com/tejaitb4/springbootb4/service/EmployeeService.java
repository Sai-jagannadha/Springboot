package com.tejaitb4.springbootb4.service;

import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejaitb4.springbootb4.model.ApiResponse;
import com.tejaitb4.springbootb4.model.Employee;
import com.tejaitb4.springbootb4.model.ResponseBuilder;
import com.tejaitb4.springbootb4.repository.EmployeeRepository;
@Service
public class EmployeeService {
@Autowired
	EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee) {
		String first_name=employee.getFname();
		String last_name=employee.getLname();
		String full_name=first_name.concat(" "+last_name);
							employee.setFullName(full_name); 
		
		Employee emp=repository.save(employee);
		return emp;
	}
public Optional<Employee> getEmployee(Integer eid) {
	Optional<Employee> opEmp=repository.findById(eid);
	return opEmp;
	
}
public List<Employee> getAllEmployees(){
//	List<Employee> list= repository.findAll();
List<Employee>	list=repository.findAllEmployeesData();
	return list;
	
}
public void DelById(Integer eid) {
	 repository.deleteById(eid);

	
}
public List<Employee> getEmployeeLessThanSalary(Long salary) {
List<Employee> list=repository.findBySalary(salary);
	return list;
}
public List<Employee> getEmployeeDepartment(String dept) {
//	return 	repository.findByDept(dept);
	
	return (List<Employee>) repository.findByDeptData(dept);
}
public List<Employee> getEmployeeGreaterThanSalary(Long salary) {
	return repository.findBySalaryGreaterThan(salary);
}

public List<Employee> getEmployeeByFnameStartingWith(String fname) {
	
	return repository.findByFnameStartingWith(fname);
}
public List<Employee> getEmployeeByFnameEndingWith(String fname) {
	return repository.findByFnameEndingWith(fname);
}
public List<Employee> getEmployeeByFnameContains(String fname) {
	
	return repository.findByFnameContaining(fname);
}
public List<Employee> getEmployeeByDistinctAge(Integer age) {
	
	return repository.findDistinctByAge(age);
}
public List<Employee> getEmployeeByGreaterThanEqual(Long salary) {
	
	return repository.findBySalaryGreaterThanEqual(salary);
}
public List<Employee> getEmployeeByAnd(String fname, String lname) {
	return repository.findByLnameAndFname(fname,lname);
}

public List<Employee> getEmployeeeFnameLike(String fname) {
	return repository.findByFnameLike(fname);
}
public List<Employee> getEmployeeeFnameEquals(String fname) {
	return repository.findByFnameEquals(fname);
}
public List<Employee> getEmployeeByAgeOrderByAgeDesc(Integer age) {
	return repository.findByAgeOrderByAgeDesc(age);
	
}
public List<Employee> getEmployeeeFnameNotLike(String fname) {
	return repository.findByFnameNotLike(fname);
}
public List<Employee> getEmployeeeFnameNotContains(String fname) {
	return repository.findByFnameNotContaining(fname);
}
public Page<Employee> paginationOfEmployees(Integer pageNum, Integer pagesize) {
	PageRequest page=PageRequest.of(pageNum,pageNum);
Page<Employee>	pagelist=repository.findAll(page);
return pagelist;
}
public List<Employee>searchingEmployeeData(String input) {
	List<Employee> list=repository.searchEmpData(input);
	return list;
}

public Boolean userAvailability(String name) {
	Boolean result=repository.existsByFname(name);
	return result;
}

public List<Employee> EmpfilterData( String filterType,String empcode ){
	List<Employee> list=null;
	String filter=filterType;
	switch (filter) {
	case "equals":
		list=repository.findByEmpCodeEquals(empcode);
		break;
	case "notEquals":
		list=repository.findByEmpCodeEquals(empcode);
		break;
	case "Contains":
		list=repository.findByEmpCodeEquals(empcode);
		break;
	case "notContains":
		list=repository.findByEmpCodeEquals(empcode);
		break;
	case "startsWith":
		list=repository.findByEmpCodeEquals(empcode);
		break;
	case "endsWith":
		list=repository.findByEmpCodeEquals(empcode);
		break;
		
	
	}
	return list;
	
}
@Autowired
ResponseBuilder response;
public ResponseEntity<ApiResponse> findAllBuilderDesign(HttpHeaders headers, List<Employee> data){
	System.out.println("service class");
	ResponseEntity<ApiResponse> res=response.buildResponse(headers, HttpStatus.OK.value(), "ALL EMPLOYEES DATA", data);
	return res;
	
}


}
