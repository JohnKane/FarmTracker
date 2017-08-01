<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>New/Edit Animal Type</h3>
    	</div>
    	<div class="panel-body">
	        <form:form action="saveAnimalType" method="post" modelAttribute="animalType">
	            <form:hidden path="key"/>
	            <div class="form-group">
	            	<form:label path="name">Name</form:label>
	                <form:input path="name" class="form-control" required="required"/>
	            </div>
	            <div>
	            	<a href="animalTypes">Cancel</a>
	            	<button type="submit" class="btn btn-primary">Submit</button>
	            </div>
	        </form:form>
	    </div>
    </div>
</div>