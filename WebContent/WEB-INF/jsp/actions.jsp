<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>Actions</h3>
    	</div>
        <div class="panel-body">
        	<form:form action="searchActions" method="post" modelAttribute="actionSearch">
	        	<div class="row">
	        		<div class="col-lg-4">
			        	<div class="input-group">
			        		<span class="input-group-addon">Search</span>
	                 		<form:input path="searchValue" class="form-control" />		
						</div>
					</div>
					<div class="col-lg-2">
			        	<button type="submit" name="action" value="search" class="btn btn-primary">Search</button>
			        	<button type="submit" name="action" value="reset" class="btn btn-default">Reset</button>
					</div>
				</div>
			</form:form>
			<div style="float:right;">
				<c:if test="${actionSearch.hasPreviousResults()}">
	        		<a href="actions?page=${actionSearch.page-1}" class="btn btn-default">&lt;&nbsp;Previous</a>
	        	</c:if>
	        	<c:if test="${actionSearch.hasNextResults()}">
	        		<a href="actions?page=${actionSearch.page+1}" class="btn btn-default">Next&nbsp;&gt;</a>
	        	</c:if>
			</div>
			<br /><br />
	        <table class="table table-striped">
	        	<th><a href="newAction" class="btn btn-info btn-xs" role="button">New Action</a></th>
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