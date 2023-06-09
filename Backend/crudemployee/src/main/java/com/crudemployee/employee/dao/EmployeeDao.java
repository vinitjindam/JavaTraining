package com.crudemployee.employee.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crudemployee.employee.model.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer>{
	
	public List<Employee> findByEmpName(String empName);
	public Employee findByDept(String dept);
	public List<Employee> findByDeptOrCity(String dept, String city);
	public List<Employee> findBySalaryGreaterThan(int value);
	public List<Employee> findBySalaryLessThan(int value);
	public List<Employee> findBySalaryGreaterThanAndCity(int value,String city);


}
