package com.tejaitb4.springbootb4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="springbootb4_employee")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Employee {
@Id
@GeneratedValue 
	private Integer eid;
	private String fname;
	private String lname;
	private String fullName;
	private String dept;
	private Integer age;
	private Long salary;
	private String empCode;
}
