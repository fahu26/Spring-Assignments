package com.fahim.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fahim.model.Department;
import com.fahim.model.Employee;

public  class EmployeeMapper implements RowMapper<Employee>{
	  
	  public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	  Employee employee = new Employee();
	  employee.setEmployeeId(rs.getInt("employee_id"));
	  employee.setEmployeeName(rs.getString("employee_name"));
	  employee.setEmployeeHireDate(rs.getDate("employee_hireDate"));
	  employee.setEmployeeJobId(rs.getString("employee_jobId"));
	  employee.setEmployeeSalary(rs.getDouble("employee_salary"));
	  employee.setEmployeeDepartment(new Department(rs.getInt("department_id"), rs.getString("department_name"), rs.getInt("department_managerId"))); 
	  return employee; 
	  }
	  
	  }