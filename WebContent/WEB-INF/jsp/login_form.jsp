<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
<%@include file="/resources/css/login.css" %>
</style>

<div class="container">
    <form:form action="loginUser" method="post" modelAttribute="user" class="form-signin">
    	<h2 class="form-signin-heading">Please sign in</h2>
    	
    	${errorMessage}
    	
    	<form:input path="email" class="form-control" required="required" placeholder="Email address" />
    	
        <form:password path="password" class="form-control" required="required" placeholder="password" />

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        
    </form:form>
</div>