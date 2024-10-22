package com.pk.employee.repository;

import com.pk.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Employee findByEmpId(Long empId);
}
