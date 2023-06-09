package com.crudemployee.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crudemployee.employee.model.Employee;
import com.crudemployee.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.FOUND);
	}
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("name/{empName}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String empName){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByName(empName),HttpStatus.FOUND);
	}
	@GetMapping("id/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(empId),HttpStatus.FOUND);
	}
	
	@DeleteMapping("{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int empId){
		return new ResponseEntity<String>(employeeService.deleteEmployee(empId),HttpStatus.FOUND);
	}
	@PutMapping("{empId}")
	public ResponseEntity<Employee> updateAuthor(@RequestBody Employee employee, @PathVariable int empId){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,empId),HttpStatus.CREATED);
	}
	
	@GetMapping("dept/{dept}")
	public ResponseEntity<Employee> getEmployeeByDept(@PathVariable String dept){
		return new ResponseEntity<Employee>(employeeService.getEmployeeByDept(dept),HttpStatus.FOUND);

	}
	@GetMapping("{dept}/{city}")
	public ResponseEntity<List<Employee>> getEmployeeByDeptOrCity(@PathVariable String dept,@PathVariable String city){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByDeptOrCity(dept,city),HttpStatus.FOUND);
	}
	
	@GetMapping("/salary>{salaryValue}")
	public ResponseEntity<List<Employee>> getEmployeeSalaryGreaterThan(@PathVariable int salaryValue){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeSalaryGreaterThan(salaryValue),HttpStatus.FOUND);
	}
	@GetMapping("/salary<{salaryValue}")
	public ResponseEntity<List<Employee>> getEmployeeSalaryLessThan(@PathVariable int salaryValue){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeSalaryLessThan(salaryValue),HttpStatus.FOUND);
	}
	
	@GetMapping("/salary>{salaryValue}/{city}")
	public ResponseEntity<List<Employee>> getEmployeeSalaryGreaterThanAndCity(@PathVariable int salaryValue,@PathVariable String city){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeSalaryGreaterThanAndCity(salaryValue,city),HttpStatus.FOUND);
	}
	
}
