package com.vcube.spbtjpa03.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.spbtjpa03.exception.ResourceNotFoundException;
import com.vcube.spbtjpa03.model.Employee;
import com.vcube.spbtjpa03.repo.IEmployeeRepo;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	
	@Autowired
	IEmployeeRepo employeeRepo;
	
	//http://localhost:9999/api/v1/getEmpList
	@GetMapping("/getEmpList")
	List<Employee> getEmployeeList(){
		List<Employee> empList=new ArrayList<>();
		 empList=employeeRepo.findAll();
		return empList;
	}
	
	@GetMapping("/getEmp/{id}")
	Employee getEmployee(@PathVariable("id") int id) throws ResourceNotFoundException {
		  return employeeRepo.findById(id).
				 orElseThrow(()-> new ResourceNotFoundException("Employee not found "+id));
	}
	
	@GetMapping("/getEmpFname/{fname}")
	Employee getEmployeeByFirstname(@PathVariable("fname") String firstname) {
		return employeeRepo.findByFirstname(firstname);
	}
	
	//http://localhost:9999/api/v1/insertEmp
	@PostMapping("/insertEmp")
	@ResponseStatus(HttpStatus.CREATED)
	Employee insertEmployee(@RequestBody Employee emp){
		 Employee employee=employeeRepo.save(emp);
		//return "Employee data has inserted successfully";
		return employee;
	}
	
	@PutMapping("/EmpUpdate/{id}")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") int id) throws ResourceNotFoundException{
		Employee emp=employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found"+id));
		
		emp.setFirstname(employee.getFirstname());
		emp.setLastname(employee.getLastname());
		emp.setUsername(employee.getUsername());
		emp.setPassword(employee.getPassword());
		emp.setAge(employee.getAge());
		emp.setSalary(employee.getSalary());
		
		final Employee updatedEmployee=employeeRepo.save(emp);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	void deleteEmployee(@PathVariable int id){
		employeeRepo.deleteById(id);
	}
	
	@PatchMapping("/updateEmp/{id}")
	Employee updateEmployee(@PathVariable int id, @RequestBody Employee empDetails) {
		return employeeRepo.findById(id).map(employee ->{
			if(empDetails.getFirstname()!=null) {
				employee.setFirstname(empDetails.getFirstname());
			}
			if(empDetails.getLastname()!=null) {
				employee.setLastname(empDetails.getLastname());
			}
			if(empDetails.getUsername()!=null) {
				employee.setUsername(empDetails.getUsername());
			}
			if(empDetails.getPassword()!=null) {
				employee.setPassword(empDetails.getPassword());
			}
			if(empDetails.getAge()!=null) {
				employee.setAge(empDetails.getAge());
			}
			if(empDetails.getSalary()!=null) {
				employee.setSalary(empDetails.getSalary());
			}
			
			return employeeRepo.save(employee);
		}).orElseThrow(()-> new RuntimeException("Employee not found with id"+id));
		
	}

}
