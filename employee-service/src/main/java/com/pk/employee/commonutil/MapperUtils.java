package com.pk.employee.commonutil;

import com.pk.employee.dto.EmployeeDto;
import com.pk.employee.model.Employee;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperUtils {

    private ModelMapper modelMapper;
    public Employee mapppingEmployeeDtoToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        modelMapper.map(employeeDto,employee);
        return employee;
    }

    public EmployeeDto mapppingEmployeeToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        modelMapper.map(employee,employeeDto);
        return employeeDto;
    }
}
