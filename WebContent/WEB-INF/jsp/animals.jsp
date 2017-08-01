<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>Animals</h3>
    	</div>
        <div class="panel-body">
        	<a href="newAnimal" class="btn btn-info" role="button">New Animal</a>
	        <table class="table table-striped">
	        	<th>&nbsp;</th>
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
    </div>
</div>