<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
    		<h3>New/Edit User</h3>
    	</div>
    	<div class="panel-body">
	        <form:form action="saveUser" method="post" modelAttribute="user">
	            <form:hidden path="key"/>
	            <div class="form-group">
                	<form:label path="farm.key">Farm</form:label>
                	<form:select path="farm.key" value="" class="form-control" required="required">
	                	<form:option value="">Select Farm</form:option>
	    				<form:options items="${farms}" itemValue="key" itemLabel="name"/>
                	</form:select>
	            </div>
	            <div class="form-group">
                	<form:label path="role.key">Farm</form:label>
                	<form:select path="role.key" value="" class="form-control" required="required">
	                	<form:option value="">Select Role</form:option>
	    				<form:options items="${roles}" itemValue="key" itemLabel="name"/>
                	</form:select>
	            </div>
	            <div class="form-group">
	            	<form:label path="email">Email</form:label>
	                <form:input path="email" class="form-control" required="required"/>
	            </div>
	            <div class="form-group">
	            	<form:label path="password">Password</form:label>
	                <form:password path="password" class="form-control" required="required"/>
	            </div>
	            <div>
	            	<a href="users">Cancel</a>
	            	<button type="submit" class="btn btn-primary">Submit</button>
	            </div>
	        </form:form>
		</div>
    </div>
</div>