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
						<li <c:if test="${uri.contains('events') || uri.contains('newEvent') || uri.contains('editEvent')}">class="active"</c:if>>
							<a href="events">Events</a>
						</li>
						<li <c:if test="${uri.contains('animals') || uri.contains('newAnimal') && !uri.contains('Type') || uri.contains('editAnimal') && !uri.contains('Type')}">class="active"</c:if>>
							<a href="animals">Animals</a>
						</li>
						<li <c:if test="${uri.contains('actions') || uri.contains('newAction') || uri.contains('editAction')}">class="active"</c:if>>
							<a href="actions">Actions</a>
						</li>
						<li <c:if test="${uri.contains('animalTypes') || uri.contains('newAnimalType') || uri.contains('editAnimalType')}">class="active"</c:if>>
							<a href="animalTypes">Animal Types</a>
						</li>
						<c:if test="${sessionScope.LOGGEDIN_USER.role.name=='Admin'}">
							<li <c:if test="${uri.contains('users') || uri.contains('newUser') || uri.contains('editUser')}">class="active"</c:if>>
								<a href="users">Users</a>
							</li>
							<li <c:if test="${uri.contains('farms') || uri.contains('newFarm') || uri.contains('editFarm')}">class="active"</c:if>>
								<a href="farms">Farms</a>
							</li>
						</c:if>	
					  </ul>
					  <ul class="nav navbar-nav navbar-right">
							<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
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