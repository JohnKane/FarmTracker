<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Users</h1>
        <h3>
            <a href="newUser">New User</a>
        </h3>
        <table border="1">
        	<th>Action</th>
        	<th>Role</th>
        	<th>Farm</th>
            <th>Email</th>
            <th>Date Created</th>
 
            <c:forEach var="user" items="${users}">
                <tr>
                	<td>
                    	<a href="editUser?key=${user.key}">Edit</a>
                    	<a href="deleteUser?key=${user.key}">Delete</a>
                   	</td>
                   	<td>${user.role.name}</td>
                   	<td>${user.farm.name}</td>
                    <td>${user.email}</td>
                    <td>${user.dateCreated}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

