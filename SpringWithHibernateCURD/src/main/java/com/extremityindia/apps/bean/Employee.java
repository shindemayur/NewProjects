package com.extremityindia.apps.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="EmployeeDataTable")
public class Employee 
{
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@Range(min = 18, max =30 ,message="Age  must be in btween 18 to 30")
	@NotNull
    private Integer age;
	
    @Column(name="sal")
    @NotNull
	private Long salary;
    
    @NotEmpty
	private String address;
    
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/*@Override
	public String toString() 
	{
		return "Employee [name=" + name + ", age=" + age + "]";
	}*/
}
