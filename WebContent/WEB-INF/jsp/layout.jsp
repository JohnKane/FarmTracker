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
	        <div class="wrap">  
	        	<tiles:insertAttribute name="body" />
	        </div>
	        <div>
	        	<tiles:insertAttribute name="footer" />
	        </div>  
	  </div>
	</body>  
</html>  