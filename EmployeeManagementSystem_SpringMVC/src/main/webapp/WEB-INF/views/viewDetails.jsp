<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" content="text/html; charset=UTF-8">
<title>Employee Details</title>
</head>
<body>
        <div align="center">
            <h1>Employee List</h1>
            <h3><a href="newEmployee">New Employee</a></h3>
            <table border="1">
                <th>Employee ID</th>
                <th>Employee Name</th>
                <th>Employee Department</th>
                <th>Employee Designation</th>
                <th>Employee Salary</th>
                 
                <c:forEach var="employee" items="${employeeList}" varStatus="status">
                <tr>
                    <td>${employee.employeeId}</td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.employeeDepartment}</td>
                    <td>${employee.employeeDesignation}</td>
                    <td>${employee.employeeSalary}</td>
                    <td>
                        <a href="updateEmployee?empId=${employee.employeeId}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteEmployee?empId=${employee.employeeId}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
</body>
</html>