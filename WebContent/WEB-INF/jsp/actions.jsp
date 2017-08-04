<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>Actions</h3>
    	</div>
        <div class="panel-body">
        	<a href="newAction" class="btn btn-info" role="button">New Action</a>
	        <table class="table table-striped">
	        	<th>&nbsp;</th>
	            <th>Name</th>
	 
	            <c:forEach var="action" items="${actions}">
	                <tr>
	                	<td>
	                    	<a href="editAction?key=${action.key}">Edit</a>
	                    	<a href="deleteAction?key=${action.key}">Delete</a>
	                   	</td>
	                    <td>${action.name}</td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
    </div>
</div>