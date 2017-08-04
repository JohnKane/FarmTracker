<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>New/Edit Action</h3>
    	</div>
    	<div class="panel-body">
	        <form:form action="saveAction" method="post" modelAttribute="action">
	            <form:hidden path="key"/>
	            <form:hidden path="farm.key"/>
	            <div class="form-group">
	            	<form:label path="name">Name</form:label>
	                <form:input path="name" class="form-control" required="required"/>
	            </div>
	            <div class="form-group">
	                <form:label path="description">Description</form:label>
	                <form:textarea path="description" rows="5" cols="30" class="form-control"/>
	            </div>
	            <div>
	            	<a href="actions">Cancel</a>
	            	<button type="submit" class="btn btn-primary">Submit</button>
	            </div>
	        </form:form>
	    </div>
    </div>
</div>
