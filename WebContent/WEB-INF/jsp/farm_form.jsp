<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <h1>New/Edit Farm</h1>
        <form:form action="saveFarm" method="post" modelAttribute="farm">
        <table>
            <form:hidden path="key"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" required="required"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                	<a href="farms">Cancel</a>
                	<input type="submit" value="Save">
                </td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>