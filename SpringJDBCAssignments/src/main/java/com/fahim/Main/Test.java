package com.fahim.Main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fahim.Dao.EmployeeDeptDaoImpl;
import com.fahim.model.Employee;

public class Test {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeDeptDaoImpl daoImpl = context.getBean("employeeDeptDaoImpl", EmployeeDeptDaoImpl.class);

		//program to display details of all the employees of a particular department
		List<Employee> empList = daoImpl.getEmployeesByDepartmentId(01);
		System.out.println("program to display details of all the employees of a particular department");
		for(Employee em:empList){
			System.out.println(em.getEmployeeId() +" , " + em.getEmployeeName() +" , " +em.getEmployeeHireDate() +" , " +em.getEmployeeJobId() +" , " +em.getEmployeeSalary());
		}

		//program to display employee details
		System.out.println();
		System.out.println("program to display employee details");
		System.out.println(daoImpl.getEmployeesByEmployeeId(11));

		//program to display name, job id and salary of employees whose jobs are either accounts or admin and whose salaries between 50000 and 60000 & sort the data in ascending order of employee names
		System.out.println();
		System.out.println("program to display name, job id and salary of employees");
		List<Employee> empList1 = daoImpl.getEmployeesByMultipleCriteria();
		for(Employee em:empList1){
			System.out.println(em.getEmployeeName() +" , " +em.getEmployeeJobId() +" , " +em.getEmployeeSalary());
		}

		//program to display name and salary of an employee who has maximum salary in a particular department.
		System.out.println();
		System.out.println("program to display name and salary of an employee who has maximum salary in a particular department.");
		Employee employee=daoImpl.getEmployeeByMaxSalaryInDepartment(3);
		System.out.println(employee.getEmployeeName()+" , "+employee.getEmployeeSalary());		

		//program to display department ids and all employees who are working in those departments. Sort the result in ascending order of department id
		System.out.println();
		System.out.println("program to display department ids and all employees who are working in those departments.");
		List<Employee> empList2 = daoImpl.getAllDepartmentWithEmployees();
		for(Employee em:empList2){
			System.out.println(em.getEmployeeDepartment().getDepartmentId() +" , "+em.getEmployeeId() +" , " +em.getEmployeeName()); }

		//program to display employee id and employee name along with his/her managerid.
		System.out.println();
		System.out.println("program to display employee id and employee name along with his/her managerid");
		List<Employee> empList3 = daoImpl.getAllEmployeesWithManagerIds();
		for(Employee em:empList3){ 
			System.out.println(em.getEmployeeId() +" , "+em.getEmployeeName()+" , "+em.getEmployeeDepartment().getDepartmentManagerId()); 
		}

		//program to display id, name, salary and department name of all employees.
		System.out.println();
		System.out.println("program to display id, name, salary and department name of all employees.");
		List<Employee> empList4 = daoImpl.getAllEmployeesDetailsWithDeptName();
		for(Employee em:empList4){ 
			System.out.println(em.getEmployeeId() +" , "+em.getEmployeeName()+" , "+em.getEmployeeSalary()+" , "+em.getEmployeeDepartment().getDepartmentName()); 
		}

		//program to insert a new department record into departments table
		System.out.println();
		System.out.println("program to insert a new department record into departments table");
		//daoImpl.insertValuesInDepartmentTable(06, "Security", 106);  uncomment if new data given otherwise let it be commented..

		//program to update salary of all employees by 5000 who are working in department 1.
		System.out.println();
		System.out.println("program to update salary of all employees by 5000 who are working in department 1");
		System.out.println("updated-->"+daoImpl.UpdateSalaryOfEmployeeesBasedOnDepartmentId(5000,1));
		
		//program to implement stored function
		System.out.println();
		System.out.println("Simple Interest: "+daoImpl.getSimpleInterest(5000, 5, 20));
		
		//program to implement stored procedure
		System.out.println();
		System.out.println("stored procs--->");
		Employee employee2 = daoImpl.getEmployeeDetailsFromStoredProcedure(11);
		System.out.println("EmployeeId: "+employee2.getEmployeeId());
		System.out.println("EmployeeName: "+employee2.getEmployeeName());
		System.out.println("EmployeeJobId: "+employee2.getEmployeeJobId());
		System.out.println("DepartmentName: "+employee2.getEmployeeDepartment().getDepartmentName());
		System.out.println("DepartmentManagerId: "+employee2.getEmployeeDepartment().getDepartmentManagerId());
	}
}
