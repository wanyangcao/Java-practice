
<%@ include file="taglibs.jsp" %>

<app:validateSession/>
<jsp:useBean id="user" scope="session" type="addressbook.model.UserBean"/>
<html:html>
<head>
<title><bean:message key="mainMenu.title"/></title>
<html:base/>
</head>
<body bgcolor="white">
<html:img page="/adrlogo.gif" alt="AddressBook Application"/>
<hr>
<center>


  <logic:messagesPresent message="true">
  <tr>
    <html:messages id="message" message="true">
    <td><bean:write name="message"/></td>
    </html:messages>
  </tr>
  </logic:messagesPresent>
  

<br>
<html:link forward="mainMenu"><bean:message key="goto.mainMenu"/></html:link>
&nbsp;&nbsp;
<html:link forward="insert"><bean:message key="goto.insert"/></html:link>
</center>
<%@ include file="footer.jsp" %>
</body>
</html:html>
