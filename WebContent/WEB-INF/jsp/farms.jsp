<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Farm Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Farms</h1>
        <h3>
            <a href="newFarm">New Farm</a>
        </h3>
        <table border="1">
        	<th>Action</th>
            <th>Name</th>
 
            <c:forEach var="farm" items="${farms}">
                <tr>
                	<td>
                    	<a href="editFarm?key=${farm.key}">Edit</a>
                    	<a href="deleteFarm?key=${farm.key}">Delete</a>
                   	</td>
                    <td>${farm.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

