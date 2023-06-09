package com.crudemployee.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crudemployee.employee.dao.EmployeeDao;
import com.crudemployee.employee.exception.EmployeAlreadyExists;
import com.crudemployee.employee.exception.EmployeeNotFound;
import com.crudemployee.employee.exception.UnableToDelete;
import com.crudemployee.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Optional<Employee> found=employeeDao.findById(employee.getEmpId());
		
		if(found.isPresent())
			throw new EmployeAlreadyExists("Employee already exists");	
		else
			return employeeDao.save(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return (List<Employee>) employeeDao.findAll();
	}
	public Employee getEmployeeById(int empId) {
		Optional<Employee> employee=employeeDao.findById(empId);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new EmployeeNotFound("Employee Not Found by id");
		}
		//return employee.get();
	}
	@Override
	public List<Employee> getEmployeeByName(String empName) {
		List<Employee> employees=employeeDao.findByEmpName(empName);
		if(employees.size()!=0) {
			return employees;
		}else
		throw new EmployeeNotFound("Employee Not Found by Name");
		//return employeeDao.findByEmpName(empName);
	}

	@Override
	public Employee updateEmployee(Employee employee, int empId) {
		
		return employeeDao.save(employee);
	}

	@Override
	public String deleteEmployee(int empId) {
		java.util.Optional<Employee> employee=employeeDao.findById(empId);
		if(employee.isPresent()) {
			employeeDao.deleteById(empId);
			
		}
		throw new UnableToDelete("ID Not Found/Unable to Delete employee ");
		
	}

	@Override
	public Employee getEmployeeByDept(String dept) {
		return employeeDao.findByDept(dept);
	}

	@Override
	public List<Employee> getEmployeeByDeptOrCity(String dept, String city) {
		return employeeDao.findByDeptOrCity(dept, city);
	}

	@Override
	public List<Employee> getEmployeeSalaryGreaterThan(int salaryValue) {
		return employeeDao.findBySalaryGreaterThan(salaryValue);	
	}
	@Override
	public List<Employee> getEmployeeSalaryLessThan(int salaryValue) {
		return employeeDao.findBySalaryLessThan(salaryValue);	
	}
	@Override
	public List<Employee> getEmployeeSalaryGreaterThanAndCity(int salaryValue,String city) {
		return employeeDao.findBySalaryGreaterThanAndCity(salaryValue,city);	
	}
}
