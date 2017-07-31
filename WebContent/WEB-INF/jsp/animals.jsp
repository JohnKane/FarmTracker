<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Animal Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Animals</h1>
        <h3>
            <a href="newAnimal">New Animal</a>
        </h3>
        <table border="1">
        	<th>Action</th>
            <th>Animal Type</th>
            <th>Name</th>
            <th>Id</th>
            <th>Birthdate</th>
            <th>Deathdate</th>
 
            <c:forEach var="animal" items="${animals}">
                <tr>
                	<td>
                    	<a href="editAnimal?key=${animal.key}">Edit</a>
                    	<a href="deleteAnimal?key=${animal.key}">Delete</a>
                   	</td>
                   	<td>${animal.animalType.name}</td>
                    <td>${animal.name}</td>
                    <td>${animal.id}</td>
                    <td>${animal.birthdate}</td>
                    <td>${animal.deathdate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

