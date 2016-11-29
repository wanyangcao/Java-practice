
<%@ include file="taglibs.jsp" %>

<br>
<logic:notPresent name="database" scope="application">
  <font color="red">
    ERROR:  User database not loaded -- check servlet container logs
    for error messages.
  </font>
  <hr>
</logic:notPresent>

<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
  <font color="red">
    ERROR:  Application resources not loaded -- check servlet container
    logs for error messages.
  </font>
</logic:notPresent>


<h3><bean:message key="index.heading"/></h3>
<html:link page="/logon.jsp"><bean:message key="index.logon"/></html:link>
<br><br>
