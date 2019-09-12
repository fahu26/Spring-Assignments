<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.formFields{border:1px solid #000;position:relative;left:30%;width:50%;height:40%;}
#updatePageOnly{display:none;}
#updatePageOnly input{pointer-events:none;background-color: rgb(235,235,228);color:rgb(84,84,84);}
form{padding:2%;}
form div{margin-bottom:2%;}
label{font-weight: bold;margin-right:2%;width:10%;}
.error{color:red;}
</style>
<title>New/Edit Employee</title>
</head>
<body>
<h1 align="center">Employee Form</h1>
<input type="hidden" value="${editPage}" id="isEditPage">
<div class="formFields">
<form:form action="saveEmployee" method="POST" modelAttribute="employee">
<div id="updatePageOnly">
<label>Enter ID</label>
<form:input path="employeeId"/>
</div>
<div>
<label>Enter Name</label>
<form:input path="employeeName"/>
<form:errors path="employeeName" cssClass="error"/>
</div>
<div>
<label>Enter Department</label>
<form:input path="employeeDepartment"/>
<form:errors path="employeeDepartment" cssClass="error"/>
</div>
<div>
<label>Enter Designation</label>
<form:input path="employeeDesignation"/>
<form:errors path="employeeDesignation" cssClass="error"/>
</div>
<div>
<label>Enter Salary</label>
<form:input path="employeeSalary"/>
<form:errors path="employeeSalary" cssClass="error"/>
</div>
<input type="submit" value="${buttonName}">
</form:form>
</div>
</body>
<script>
if(document.getElementById("isEditPage").value=="true"){
	document.getElementById("updatePageOnly").style.display="block";
	}
</script>

</html>