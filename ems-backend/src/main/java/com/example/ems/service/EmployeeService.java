package com.example.ems.service;

import java.util.List;

import com.example.ems.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createNewEmployee(EmployeeDto emp);
	
	EmployeeDto getEmployeebyId(Long id);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto emp);
	
	void deleteById(Long id);
}
