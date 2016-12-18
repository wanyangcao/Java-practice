<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Portfolio Account Update</title>
   <s:head/>
	</head>

	<body>
		<h4>Please edit your account. </h4> 
		<s:form action="UpdateAccount">
    	  <s:label key="username" />
    	  <s:hidden name="username" />
    	  <s:password name="password" label="Password" showPassword="true"/>  
    	  <s:checkbox name="receiveJunkMail"  label="Do you want to receive junk mail?" />
    	  <s:submit/>
		</s:form>	 
		
	</body>
	
</html>
