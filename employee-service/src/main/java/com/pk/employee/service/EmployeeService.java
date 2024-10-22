package com.pk.employee.service;

import com.pk.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long empId);

    EmployeeDto updateEmployeeDetailsById(Long id, EmployeeDto empDto);

    EmployeeDto deleteEmployeeDetailsById(Long id);

    List<EmployeeDto> getAllEmployee();
}
