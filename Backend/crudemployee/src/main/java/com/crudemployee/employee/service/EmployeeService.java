package com.crudemployee.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crudemployee.employee.model.Employee;

@Service
public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int empId);
	public List<Employee> getEmployeeByName(String empName);
	
	public Employee updateEmployee(Employee employee,int empId);
	
	public String deleteEmployee(int empId);
	
	public Employee getEmployeeByDept(String dept);
	
	public List<Employee> getEmployeeByDeptOrCity(String dept,String city);
	
	public List<Employee> getEmployeeSalaryGreaterThan(int salaryValue);
	public List<Employee> getEmployeeSalaryLessThan(int salaryValue);
	
	public List<Employee> getEmployeeSalaryGreaterThanAndCity(int salaryValue,String city);

}
