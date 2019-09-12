package com.fahim.dao;

import java.util.List;

import com.fahim.model.Employee;

public interface EmployeeDao {
	public void saveOrUpdate(Employee employee);
	public Employee getEmployee(int empId);
	public List<Employee> getAllEmployee();
	public void delete(int empId);
	//public void update(Employee employee);
}
