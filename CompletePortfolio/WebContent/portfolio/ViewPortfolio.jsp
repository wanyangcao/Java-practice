<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    	<title>Viewing Portfolio</title>
	</head>
	<body>
		<h5>
			This is the <s:property value="portfolioName"/> portfolio of the artist currently 
			known as <s:property value="username"/>
			
		</h5>
		<a href="<s:url action='PortfolioHomePage'/>">Home</a>
	</body>
	
</html>
