<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html>  
	<head>  
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	</head>  
	<body>  
		<div id="body" >
	        <div id="header">
	        	<tiles:insertAttribute name="header" />
	        </div>  
	        <div id="navigation" class="wrap">
		        <nav class="navbar navbar-default">
				  <div class="container-fluid">
				  	  <c:set var="uri" value="${requestScope['javax.servlet.forward.request_uri']}" />
					  <ul class="nav navbar-nav">
						<li <c:if test="${uri.contains('home')}">class="active"</c:if>>
							<a href="home">Home</a>
						</li>
					  </ul>
					  <ul class="nav navbar-nav navbar-right">
							<li><a href="logout"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Login</a></li>
					  </ul>
					</div>
				</nav>
	        </div>
	        <div id="main" class="wrap">  
	        	<tiles:insertAttribute name="body" />
	        </div>
	        <div id="footer" class="wrap">
	        	<tiles:insertAttribute name="footer" />
	        </div>  
	  </div>
	</body>  
</html>  