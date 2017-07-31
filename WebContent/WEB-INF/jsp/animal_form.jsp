<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Animal</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Animal</h1>
        <form:form action="saveAnimal" method="post" modelAttribute="animal">
        <table>
            <form:hidden path="key"/>
            <tr>
                <td>Animal Type:</td>
                <td>
                	<form:select path="animalType.key" value="" required="required">
	                	<form:option value="">Select Animal Type</form:option>
	    				<form:options items="${animalTypes}" itemValue="key" itemLabel="name"/>
                	</form:select>
                </td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Id:</td>
                <td><form:input path="id"/></td>
            </tr>
            <tr>
                <td>Birthdate:</td>
                <td><form:input path="birthdate" type="date"/></td>
            </tr>
            <tr>
                <td>Deathdate:</td>
                <td><form:input path="deathdate" type="date"/></td>
            </tr>
            <tr>
                <td>Notes:</td>
                <td><form:textarea path="notes" rows="5" cols="30"/></td>
            </tr>
            <tr>
                <td>Children:</td>
                <td>
                	<form:select path="childKeys" multiple="multiple">
	    				<form:options items="${animals}" itemValue="key" itemLabel="name"/>
                	</form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                	<a href="animals">Cancel</a>
                	<input type="submit" value="Save">
                </td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>