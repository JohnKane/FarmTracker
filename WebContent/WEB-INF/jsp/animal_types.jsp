<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>Animal Types</h3>
    	</div>
    	<div class="panel-body">
            <a href="newAnimalType" class="btn btn-info" role="button">New Animal Type</a>
	        <table class="table table-striped">
	        	<th>&nbsp;</th>
	            <th>Name</th>
	 
	            <c:forEach var="type" items="${animalTypes}">
	                <tr>
	                	<td>
	                    	<a href="editAnimalType?key=${type.key}">Edit</a>
	                    	<a href="deleteAnimalType?key=${type.key}">Delete</a>
	                   	</td>
	                    <td>${type.name}</td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
    </div>
</div>
