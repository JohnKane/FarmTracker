<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<div class="container">
	<div class="panel panel-default">
    	<div class="panel-heading">
    		<h3>Users</h3>
    	</div>
    	<div class="panel-body">
        	<a href="newUser" class="btn btn-info" role="button">New User</a>
		    <table class="table table-striped">
		    	<th>&nbsp;</th>
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
    </div>
</div>

