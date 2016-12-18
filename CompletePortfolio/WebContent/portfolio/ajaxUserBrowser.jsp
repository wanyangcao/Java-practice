<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<script src="ajaxUserBrowser.js" type="text/javascript"/>
<link rel="stylesheet" type="text/css" href="css/ajaxUserBrowser.css"/>
</head>
<body>
   <h5>Artist Browser Control</h5>   
   <s:form action="AjaxRetrieveUser">
      <s:select name="username" list='users' listKey="username" listValue="username" label="Select an artist" value="defaultUsername" onchange="fetchUser();"/>  
   </s:form>	
   <hr/>
   <h5>Artist Information</h5>      
   <div id='console'>
      <p>Name: <s:property value="defaultUser.firstName"/> <s:property value="defaultUser.lastName"/></p>
      <s:iterator value="defaultUser.portfolios">
        <p>PortfolioName: <s:property value="value.name" />  </p>
      </s:iterator>
   </div>
</body>
</html>