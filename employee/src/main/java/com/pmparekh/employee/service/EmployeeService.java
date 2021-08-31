package com.pmparekh.employee.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmparekh.employee.exceptions.UserNotFoundException;
import com.pmparekh.employee.model.Employee;
import com.pmparekh.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		// This is known as query method since spring doesn't have a default method like this.
		// We need to define it in t the repository by ourselfs
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id "+id+" was not found"));
	}
	
	@Transactional
	public void deleteEmployee(Long id) {
		employeeRepository.deleteEmployeeById(id);
	}
	
}
