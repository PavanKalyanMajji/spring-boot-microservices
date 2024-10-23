package com.pk.employee.controller;

import com.pk.employee.dto.EmployeeDto;
import com.pk.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employeeservice")
@AllArgsConstructor
public class employeeController {

    private EmployeeService employeeService;
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Success");
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployeeDetails(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<EmployeeDto>(employeeService.saveEmployee(employeeDto), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployeeDetails () {
        return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
    }

    @GetMapping("/getemp")
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeDetailsById(@PathVariable("id") Long id,@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.updateEmployeeDetailsById(id,employeeDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteemp")
    public ResponseEntity<EmployeeDto> deleteEmployeeDetailsById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(employeeService.deleteEmployeeDetailsById(id),HttpStatus.OK);
    }
}
