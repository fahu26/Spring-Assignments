package com.fahim.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.fahim.RowMapper.EmployeeMapper;
import com.fahim.model.Department;
import com.fahim.model.Employee;
public class EmployeeDeptDaoImpl {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	//program to display details of all the employees of a particular department
	public List<Employee> getEmployeesByDepartmentId(int dept_id) {
		String sql="select * from employee e join department d "
				+ "on e.employee_DepartmentId=d.department_id"
				+ " where e.employee_departmentId=?";
		List<Employee> query = jdbcTemplate.query(sql,new Object[] {dept_id}, new EmployeeMapper());
		return query;
	}

	//program to display employee details
	public Employee getEmployeesByEmployeeId(int emp_id) {
		String sql="select * from employee e join department d on e.employee_departmentId= d.department_id where e.employee_id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {emp_id}, new EmployeeMapper());

	}

	//program to display name, job id and salary of employees whose jobs are either accounts or admin and whose salaries between 50000 and 60000 & sort the data in ascending order of employee names
	public List<Employee> getEmployeesByMultipleCriteria(){
		String sql="Select * from employee e "
				+ "join department d on e.employee_departmentId= d.department_id"
				+ " where (d.department_name='admin' or d.department_name='accounts')"
				+ " and e.employee_salary between 50000 and 60000 "
				+ "order by e.employee_name";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	//program to display name and salary of an employee who has maximum salary in a particular department.
	public Employee getEmployeeByMaxSalaryInDepartment(int dept_id) {
		String sql="select employee_name,max(employee_salary) as employee_Salary from employee "
				+ "where employee_departmentId=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {dept_id}, new EmployeeMapper1());
	}

	private static class EmployeeMapper1 implements RowMapper<Employee>{
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEmployeeName(rs.getString("employee_name"));
			employee.setEmployeeSalary(rs.getDouble("employee_salary"));
			return employee; 
		}
	}

	//program to display department ids and all employees who are working in those departments. Sort the result in ascending order of department id
	public List<Employee> getAllDepartmentWithEmployees(){
		String sql="select * "
				+ "from employee e join department d "
				+ "on e.employee_departmentId=d.department_id order by department_id";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	//program to display employee id and employee name along with his/her managerid.
	public List<Employee> getAllEmployeesWithManagerIds(){
		String sql="select *"
				+ " from employee e join department d "
				+ "on e.employee_departmentId= d.department_id";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	//program to display id, name, salary and department name of all employees.
	public List<Employee> getAllEmployeesDetailsWithDeptName(){
		String sql="select *"
				+ " from employee e join department d "
				+ "on e.employee_departmentId= d.department_id";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	//program to insert a new department record into departments table
	public int insertValuesInDepartmentTable(int dept_id,String dept_name,int dept_managerId) {
		String sql="insert into department values("+dept_id+","+"'"+dept_name+"'"+","+dept_managerId+")";
		return jdbcTemplate.update(sql);

	}

	//program to update salary of all employees by 5000 who are working in department 1.
	public int UpdateSalaryOfEmployeeesBasedOnDepartmentId(double amount,int dept_id){
		String sql="update employee set employee_salary=employee_Salary+"+amount+" where employee_departmentId="+dept_id;
		return jdbcTemplate.update(sql);
	}

	//program to implement stored procedure
	public Employee getEmployeeDetailsFromStoredProcedure(int emp_id) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("display_employeeDetails");
		SqlParameterSource in = new MapSqlParameterSource().addValue("employee_id", emp_id);
		Map<String,Object> out=jdbcCall.execute(in);
		Employee employee = new Employee();
		employee.setEmployeeId((Integer) out.get("out_empid"));
		employee.setEmployeeName((String) out.get("out_empname"));
		employee.setEmployeeJobId((String) out.get("out_empjobid"));
		employee.setEmployeeDepartment(new Department((Integer)out.get("out_deptid"),(String) out.get("out_deptname"), (Integer) out.get("out_deptmgid")));
		return employee;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
