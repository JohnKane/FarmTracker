<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Animal Type Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Animal Types</h1>
        <h3>
            <a href="newAnimalType">New Animal Type</a>
        </h3>
        <table border="1">
        	<th>Action</th>
            <th>Name</th>
 
            <c:forEach var="type" items="${animalTypes}">
                <tr>
                	<td>
                    	<a href="editAnimalType?key=$type.key}">Edit</a>
                    	<a href="deleteAnimalType?key=${type.key}">Delete</a>
                   	</td>
                    <td>${type.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

