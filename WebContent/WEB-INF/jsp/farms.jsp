<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>Farms</h3>
    	</div>
    	<div class="panel-body">
        	<a href="newFarm" class="btn btn-info" role="button">New Farm</a>

	        <table class="table table-striped">
	        	<th>&nbsp;</th>
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
    </div>
</div>