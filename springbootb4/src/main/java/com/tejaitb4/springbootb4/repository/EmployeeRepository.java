package com.tejaitb4.springbootb4.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tejaitb4.springbootb4.model.Employee;
@Repository
public  interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findBySalary(Long salary);
	
	//public List<Employee> findByDept(String dept);

	public List<Employee>findBySalaryGreaterThan(Long salary);
	
	public List<Employee> findByFnameStartingWith(String fname);
	
	public List<Employee> findByFnameEndingWith(String fname);
	
	public List<Employee> findByFnameContaining(String fname);
	
	public List<Employee> findDistinctByAge(Integer age);
	
	public List<Employee>findBySalaryGreaterThanEqual(Long salary);
	
	public List<Employee>findByLnameAndFname(String fname, String lname);
	
	public List<Employee> findByAgeOrderByAgeDesc(Integer age);
	
	public List<Employee>findByFnameLike(String fname);
	
	public List<Employee> findByFnameEquals(String fname);
	
	public List<Employee>findByFnameNotLike(String fname);
	
	public List<Employee>findByFnameNotContaining(String fname);
	
	 @Query("select e from Employee e ")
	 public List<Employee> findAllEmployeesData();
	 
	 @Query("select u from Employee u where u.dept = :department ")
	 Employee findByDeptData(@Param("department") String department);
	 
	 
	 @Query("SELECT u FROM Employee u WHERE u.fname LIKE CONCAT('%',:input,'%')"
	            + " Or u.lname LIKE CONCAT('%',:input,'%')"
	            + " Or u.dept LIKE CONCAT('%',:input,'%')"
	            + " Or u.age LIKE CONCAT('%',:input,'%')"
	            + "Or u.salary LIKE CONCAT('%',:input,'%')")
	    public List<Employee> searchEmpData(String input);
	 
	 public Boolean existsByFname(String name);
	 
		/*---------------------starts with------------------*/
	 
	 public List<Employee>findByEmpCodeNot(String empcode);
	 
	 public List<Employee>findByEmpCodeNotContaining(String empcode);
	 
	 public List<Employee> findByEmpCodeEquals(String empcode);
	 
	 public List<Employee> findByEmpCodeContaining(String empcode);
	 
	 public List<Employee> findByEmpCodeStartingWith(String empcode);
	 
	 public List<Employee> findByEmpCodeEndingWith(String empcode);
	 
		/*------------------ ends with------------------ */
	 
	 
	 
	 

}
