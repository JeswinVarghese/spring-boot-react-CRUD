package com.example.ems.mapper;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.entity.Employee;

public class EmployeeMapper {
	
	// Or use modelMapper
	public static Employee converttoEntity(EmployeeDto emp) {
		return Employee.builder()
						  .firstName(emp.getFirstName())
						  .lastName(emp.getLastName())
						  .email(emp.getEmail())
						  .build();
	}
	
	
	
	public static EmployeeDto converttoDto(Employee emp){
		EmployeeDto employeeDto = new EmployeeDto(
				emp.getId(),
				emp.getFirstName(),
				emp.getLastName(),
				emp.getEmail()
        );
        return employeeDto;
    }

}
