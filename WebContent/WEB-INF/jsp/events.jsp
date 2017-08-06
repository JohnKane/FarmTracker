<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>Events</h3>
    	</div>
        <div class="panel-body ">
        	<form:form action="searchEvents" method="post" modelAttribute="eventSearch">
	        	<div class="row">
	        		<div class="col-lg-2">
			        	<div class="input-group">
		                	<form:select path="searchType" class="form-control">
			                	<form:option value="">Search By</form:option>
			                	<form:option value="0">Action</form:option>
			                	<form:option value="1">Animal Name</form:option>
			                	<form:option value="2">Animal Id</form:option>
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
			<br />
			<div style="float:right;">
				<c:if test="${eventSearch.hasPreviousResults()}">
	        		<a href="events?page=${eventSearch.page-1}" class="btn btn-default">&lt;&nbsp;Previous</a>
	        	</c:if>
	        	<c:if test="${eventSearch.hasNextResults()}">
	        		<a href="events?page=${eventSearch.page+1}" class="btn btn-default">Next&nbsp;&gt;</a>
	        	</c:if>
			</div>
			<br /><br />
	        <table class="table table-striped">
	        	<th><a href="newEvent" class="btn btn-info btn-xs" role="button">New Event</a></th>
	        	<th>Action</th>
	        	<th>Animal Type</th>
	        	<th>Animal Name</th>
	        	<th>Animal Id</th>
	            <th>Date</th>
	 
	            <c:forEach var="event" items="${events}">
	                <tr>
	                	<td>
	                    	<a href="editEvent?key=${event.key}">Edit</a>
	                    	<a href="deleteEvent?key=${event.key}">Delete</a>
	                   	</td>
	                    <td>${event.action.name}</td>
	                    <td>${event.animal.animalType.name}</td>
	                    <td>${event.animal.name}</td>
	                    <td>${event.animal.id}</td>
	                    <td><fmt:formatDate type="date" pattern="MM/dd/yyyy" value="${event.eventDate}" /></td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
    </div>
</div>