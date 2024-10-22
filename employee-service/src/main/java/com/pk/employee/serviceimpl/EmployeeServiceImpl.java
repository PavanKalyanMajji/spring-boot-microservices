package com.pk.employee.serviceimpl;

import com.pk.employee.commonutil.MapperUtils;
import com.pk.employee.dto.EmployeeDto;
import com.pk.employee.model.Employee;
import com.pk.employee.repository.EmployeeRepository;
import com.pk.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    private MapperUtils mapperUtils;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee emp = mapperUtils.mapppingEmployeeDtoToEmployee(employeeDto);
        emp=repository.save(emp);
        employeeDto = mapperUtils.mapppingEmployeeToEmployeeDto(emp);
        return employeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long empId) {
        Employee emp=repository.findById(empId).orElseThrow(() -> new RuntimeException("Emp Id Not found"));
        return mapperUtils.mapppingEmployeeToEmployeeDto(emp);
    }

    @Override
    public EmployeeDto updateEmployeeDetailsById(Long id,EmployeeDto empDto) {
        EmployeeDto emp=getEmployeeById(id);
        emp.setEmpDep(empDto.getEmpDep());
        emp.setEmpName(empDto.getEmpName());

        Employee employee=mapperUtils.mapppingEmployeeDtoToEmployee(emp);

        return mapperUtils.mapppingEmployeeToEmployeeDto(repository.save(employee));
    }

    @Override
    public EmployeeDto deleteEmployeeDetailsById(Long id) {
        EmployeeDto emp=getEmployeeById(id);
        repository.deleteById(emp.getEmpId());
        return emp;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> listOfAllEmployees = new ArrayList<>();
        return repository.findAll().stream().map(empObject -> mapperUtils.mapppingEmployeeToEmployeeDto(empObject)).collect(Collectors.toList());
    }
}
