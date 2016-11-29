
<%@ include file="taglibs.jsp" %>
<app:validateSession/>
<jsp:useBean id="user" scope="session" type="addressbook.model.UserBean"/>
<center>
<table border="0">
<tr><td>
<bean:message key="mainMenu.description"/>
</td></tr>
</table>
<hr>
<table border="0" cellspacing="0" cellpadding="0">

	<tr><td><li><html:link forward="search"><bean:message key="mainMenu.search"/></html:link></li></td></tr>
	<tr><td><li><html:link forward="displayall"><bean:message key="mainMenu.displayall"/></html:link></li></td></tr>
	<tr><td><li><html:link forward="insert"><bean:message key="mainMenu.insert"/></html:link></li></td></tr>
	<tr><td><li><html:link forward="logoff"><bean:message key="mainMenu.logoff"/></html:link></li></td></tr>

</table>
</center>
