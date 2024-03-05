package com.example.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;	
	
	@PostMapping("/addEmployee")
	ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto) {
		EmployeeDto employeeDto = employeeService.createNewEmployee(empDto);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}

	@GetMapping("/getEmployee/{id}")
	ResponseEntity<EmployeeDto> getEmployeeWithId(@PathVariable("id") Long id){
		EmployeeDto employeeDto = employeeService.getEmployeebyId(id);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployees")
	ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee")
	ResponseEntity<EmployeeDto> updateEmployee(@RequestParam Long id,@RequestBody EmployeeDto empDto ){
	    EmployeeDto employee = employeeService.updateEmployee(id, empDto);
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	ResponseEntity<String> deleteEmployee(@PathVariable Long id){
	    employeeService.deleteById(id);
		return ResponseEntity.ok("Employee Deleted Successfully");
	}
}
