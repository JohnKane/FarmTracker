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
			                	<form:option value="1">Name</form:option>
			                	<form:option value="2">Id</form:option>
		                	</form:select>
						</div>
					</div>
	        		<div class="col-lg-4">
			        	<div class="input-group">
			        		<span class="input-group-addon">Search</span>
	                 		<form:input path="searchValue" class="form-control" />		
						</div>
					</div>
					<div class="col-lg-4">
			        	<button type="submit" name="action" value="search" class="btn btn-primary">Search</button>
			        	<button type="submit" name="action" value="reset" class="btn btn-default">Reset</button>
					</div>
				</div>
			</form:form>
			<br />
        	<a href="newEvent" class="btn btn-info" role="button">New Event</a>
	        <table class="table table-striped">
	        	<th>&nbsp;</th>
	        	<th>Action</th>
	        	<th>Animal</th>
	        	<th>Id</th>
	            <th>Date</th>
	 
	            <c:forEach var="event" items="${events}">
	                <tr>
	                	<td>
	                    	<a href="editEvent?key=${event.key}">Edit</a>
	                    	<a href="deleteEvent?key=${event.key}">Delete</a>
	                   	</td>
	                    <td>${event.action.name}</td>
	                    <td>${event.animal.name}</td>
	                    <td>${event.animal.id}</td>
	                    <td><fmt:formatDate type="date" pattern="MM/dd/yyyy" value="${event.eventDate}" /></td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
    </div>
</div>