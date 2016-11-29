
<%@ include file="taglibs.jsp" %>

<app:validateSession/>
<jsp:useBean id="user" scope="session" type="addressbook.model.UserBean"/>
<center>
<h2>Displaying all the Addresses found...</h2>
<app:display  />

<html:link forward="mainMenu"><bean:message key="goto.mainMenu"/></html:link>
&nbsp;&nbsp;
<html:link forward="search"><bean:message key="goto.search"/></html:link>
</center>
