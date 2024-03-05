package com.example.ems.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.entity.Employee;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.mapper.EmployeeMapper;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor	
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto createNewEmployee(EmployeeDto empDto) {
		Employee emp = EmployeeMapper.converttoEntity(empDto);
		Employee savedEmp = employeeRepository.save(emp);
		return EmployeeMapper.converttoDto(savedEmp);
	}

	@Override
	public EmployeeDto getEmployeebyId(Long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : "+id));
		return EmployeeMapper.converttoDto(emp);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> employeesList = new ArrayList<>();
		employeesList = employeeRepository.findAll().stream().map(employee-> EmployeeMapper.converttoDto(employee)).toList();
		return employeesList;
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
		Employee emp = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : "+employeeId));
		if(employeeDto.getFirstName()!=null) {
			emp.setFirstName(employeeDto.getFirstName());
		}
		if(employeeDto.getLastName()!=null) {
			emp.setLastName(employeeDto.getLastName());
		}
		if(employeeDto.getEmail()!=null) {
			emp.setEmail(employeeDto.getEmail());
		}
		Employee employee = employeeRepository.save(emp);
		return EmployeeMapper.converttoDto(employee);
	}

	@Override
	public void deleteById(Long employeeId) {
		employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : "+employeeId));
		employeeRepository.deleteById(employeeId);
		
	}

}
