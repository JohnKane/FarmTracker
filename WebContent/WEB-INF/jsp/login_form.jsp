<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<div class="container">
    <form:form action="loginUser" method="post" modelAttribute="user" class="form-signin">
    	<h2 class="form-signin-heading">Please sign in</h2>
    	
    	${errorMessage}
    	
    	<form:input path="email" class="form-control" required="required" placeholder="Email address" />
    	
        <form:password path="password" class="form-control" required="required" placeholder="password" />

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        
    </form:form>
</div>