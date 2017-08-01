<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>New/Edit Animal</h3>
    	</div>
    	<div class="panel-body">
	        <form:form action="saveAnimal" method="post" modelAttribute="animal">
	            <form:hidden path="key"/>
	            <div class="form-group">
                	<form:label path="animalType.key">Animal Type</form:label>
                	<form:select path="animalType.key" class="form-control" required="required">
	                	<form:option value="">Select Animal Type</form:option>
	    				<form:options items="${animalTypes}" itemValue="key" itemLabel="name"/>
                	</form:select>
	            </div>
				<div class="form-group">
	            	<form:label path="name">Name</form:label>
	                <form:input path="name" class="form-control"/>
	            </div>
	            <div class="form-group">
	            	<form:label path="id">Id</form:label>
	                <form:input path="id" class="form-control"/>
	            </div>
	            <div class="form-group">
	                <form:label path="birthdate">Birthdate</form:label>
	                <form:input path="birthdate" type="date" class="form-control"/>
	            </div>
	            <div class="form-group">
	                <form:label path="deathdate">Deathdate</form:label>
	                <form:input path="deathdate" type="date" class="form-control"/>
	            </div>
	            <div class="form-group">
	                <form:label path="notes">Notes</form:label>
	                <form:textarea path="notes" rows="5" cols="30" class="form-control"/>
	            </div>
	            <div class="form-group">
	                <form:label path="childKeys">Children</form:label>
                	<form:select path="childKeys" multiple="multiple" class="form-control">
	    				<form:options items="${animals}" itemValue="key" itemLabel="name"/>
                	</form:select>
	            </div>
	            <div>
	            	<a href="animals">Cancel</a>
	            	<button type="submit" class="btn btn-primary">Submit</button>
	            </div>
	        </form:form>
	    </div>
    </div>
</div>