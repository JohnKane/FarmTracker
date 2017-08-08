<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>Animals</h3>
    	</div>
        <div class="panel-body">
        	<form:form action="searchAnimals" method="post" modelAttribute="animalSearch">
	        	<div class="row">
	        		<div class="col-lg-2">
			        	<div class="input-group">
		                	<form:select path="searchType" class="form-control">
			                	<form:option value="">Search By</form:option>
			                	<form:options items="${searchTypes}" itemValue="key" itemLabel="value"/>
		                	</form:select>
						</div>
					</div>
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
				<c:if test="${animalSearch.hasPreviousResults()}">
	        		<a href="animals?page=${animalSearch.page-1}" class="btn btn-default">&lt;&nbsp;Previous</a>
	        	</c:if>
	        	<c:if test="${animalSearch.hasNextResults()}">
	        		<a href="animals?page=${animalSearch.page+1}" class="btn btn-default">Next&nbsp;&gt;</a>
	        	</c:if>
			</div>
			<br /><br />
	        <table class="table table-striped">
	        	<th><a href="newAnimal" class="btn btn-info btn-xs" role="button">New Animal</a></th>
	            <th>Animal Type</th>
	            <th>Animal Name</th>
	            <th>Animal Id</th>
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
	                    <td><fmt:formatDate type="date" pattern="MM/dd/yyyy" value="${animal.birthdate}" /></td>
	                    <td><fmt:formatDate type="date" pattern="MM/dd/yyyy" value="${animal.deathdate}" /></td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
    </div>
</div>