<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Farm</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit User</h1>
        <form:form action="saveUser" method="post" modelAttribute="user">
        <table>
            <form:hidden path="key"/>
            <tr>
                <td>Farm:</td>
                <td>
                	<form:select path="farm.key" value="" required="required">
	                	<form:option value="">Select Farm</form:option>
	    				<form:options items="${farms}" itemValue="key" itemLabel="name"/>
                	</form:select>
                </td>
            </tr>
            <tr>
                <td>Role:</td>
                <td>
                	<form:select path="role.key" value="" required="required">
	                	<form:option value="">Select Role</form:option>
	    				<form:options items="${roles}" itemValue="key" itemLabel="name"/>
                	</form:select>
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" required="required"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password path="password" value="" required="required"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                	<a href="users">Cancel</a>
                	<input type="submit" value="Save">
                </td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>