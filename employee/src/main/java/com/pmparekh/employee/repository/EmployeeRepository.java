package com.pmparekh.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmparekh.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
