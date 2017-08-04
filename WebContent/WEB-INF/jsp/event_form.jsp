<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>New/Edit Event</h3>
    	</div>
    	<div class="panel-body">
	        <form:form action="saveEvent" method="post" modelAttribute="event">
	            <form:hidden path="key"/>
	            <div class="form-group">
                	<form:label path="action.key">Action</form:label>
                	<form:select path="action.key" class="form-control" required="required">
	                	<form:option value="">Select Action</form:option>
	    				<form:options items="${actions}" itemValue="key" itemLabel="name"/>
                	</form:select>
	            </div>
				<div class="form-group">
                	<form:label path="animal.key">Animal</form:label>
                	<form:select path="animal.key" class="form-control" required="required">
	                	<form:option value="">Select Animal</form:option>
	    				<form:options items="${animals}" itemValue="key" itemLabel="name"/>
                	</form:select>
	            </div>
	            <div class="form-group">
	                <form:label path="eventDate">Event Date</form:label>
	                <form:input path="eventDate" type="date" class="form-control"/>
	            </div>
	            <div class="form-group">
	                <form:label path="notes">Notes</form:label>
	                <form:textarea path="notes" rows="5" cols="30" class="form-control"/>
	            </div>
	            <div>
	            	<a href="events">Cancel</a>
	            	<button type="submit" class="btn btn-primary">Submit</button>
	            </div>
	        </form:form>
	    </div>
    </div>
</div>