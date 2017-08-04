<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>Events</h3>
    	</div>
        <div class="panel-body">
        	<a href="newEvent" class="btn btn-info" role="button">New Event</a>
	        <table class="table table-striped">
	        	<th>&nbsp;</th>
	        	<th>Action</th>
	        	<th>Animal</th>
	            <th>Date</th>
	 
	            <c:forEach var="event" items="${events}">
	                <tr>
	                	<td>
	                    	<a href="editEvent?key=${event.key}">Edit</a>
	                    	<a href="deleteEvent?key=${event.key}">Delete</a>
	                   	</td>
	                    <td>${event.action.name}</td>
	                    <td>${event.animal.name}</td>
	                    <td><fmt:formatDate type="date" pattern="MM/dd/yyyy" value="${event.eventDate}" /></td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
    </div>
</div>