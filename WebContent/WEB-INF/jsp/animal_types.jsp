<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>Animal Types</h3>
    	</div>
    	<div class="panel-body">
    		<form:form action="searchAnimalTypes" method="post" modelAttribute="animalTypeSearch">
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
				<c:if test="${animalTypeSearch.hasPreviousResults()}">
	        		<a href="animalTypes?page=${animalTypeSearch.page-1}" class="btn btn-default">&lt;&nbsp;Previous</a>
	        	</c:if>
	        	<c:if test="${animalTypeSearch.hasNextResults()}">
	        		<a href="animalTypes?page=${animalTypeSearch.page+1}" class="btn btn-default">Next&nbsp;&gt;</a>
	        	</c:if>
			</div>
			<br /><br />
	        <table class="table table-striped">
	        	<th><a href="newAnimalType" class="btn btn-info btn-xs" role="button">New Animal Type</a></th>
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
