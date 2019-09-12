package com.fahim.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fahim.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void saveOrUpdate(Employee employee) {
		if(employee.getEmployeeId()>0) {
			String sql="update employee set employeeName=?,employeeDepartment=?,"
					+ "employeeDesignation=?,employeeSalary=? where employeeId=?";
			jdbcTemplate.update(sql,employee.getEmployeeName(),employee.getEmployeeDepartment()
					,employee.getEmployeeDesignation(),employee.getEmployeeSalary(),employee.getEmployeeId());
			System.out.println("Employee Updated");	

		}
		else {
			String sql="insert into employee(employeeName,employeeDepartment,"
					+ "employeeDesignation,employeeSalary) values(?,?,?,?)";
			jdbcTemplate.update(sql, employee.getEmployeeName(),employee.getEmployeeDepartment(),
					employee.getEmployeeDesignation(),employee.getEmployeeSalary());
			System.out.println("Employee Added");
		}
	}

	@Override public Employee getEmployee(int empId) { String
		sql="select * from employee where employeeId="+empId; return
				jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Employee.
						class)); }


	@Override
	public List<Employee> getAllEmployee() {
		String sql="select * from employee";
		List<Employee> list= jdbcTemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setEmployeeName(rs.getString("employeeName"));
				employee.setEmployeeDepartment(rs.getString("employeeDepartment"));
				employee.setEmployeeDesignation(rs.getString("employeeDesignation"));
				employee.setEmployeeSalary(rs.getDouble("employeeSalary"));
				return employee;
			}
		});
		return list;
	}

	@Override
	public void delete(int empId) {
		String sql="Delete from employee where employeeId=?";
		jdbcTemplate.update(sql,empId);
		System.out.println("Employee Deleted");
	}

	/*
	 * @Override public void update(Employee employee) { String
	 * sql="update employee set employeeName=?,employeeDepartment=?," +
	 * "employeeDesignation=?,employeeSalary=? where employeeId=?";
	 * jdbcTemplate.update(sql,employee.getEmployeeName(),employee.
	 * getEmployeeDepartment()
	 * ,employee.getEmployeeDesignation(),employee.getEmployeeSalary(),employee.
	 * getEmployeeId()); System.out.println("Employee Updated"); }
	 */

}
