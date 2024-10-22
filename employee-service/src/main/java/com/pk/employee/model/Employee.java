package com.pk.employee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "emp_dep",nullable = false)
    private String empDep;
    @Column(name = "emp_name",nullable = false)
    private String empName;
}
