<%@ include file="taglibs.jsp" %>
<app:validateSession/>

<html:errors/>

<html:form action="/insert.do" focus="title">
<center>
<table border="0" cellspacing="2" cellpadding="2" width="100%">
  <tr>
    <td align="right"> <bean:message key="prompt.name"/></td>
    <td><html:text property="name" size="25" maxlength="25"/></td>
  </tr>
  <tr>
    <td align="right"> <bean:message key="prompt.phone"/></td>
    <td><html:text property="phone" size="25" maxlength="11"/></td>
  </tr>
  <tr>
    <td align="right"> <bean:message key="prompt.address"/></td>
    <td><html:text property="address" size="25" maxlength="50"/></td>
  </tr>
  <tr>
    <td align="right">
      <html:submit property="submit" >                     
      <bean:message key="button.insert"/>
      </html:submit>
    </td>
    <td align="left">
      <html:reset  >                     
      <bean:message key="button.reset"/>
      </html:reset>
    </td>
  </tr>
</table>
</center>
</html:form>
<html:link forward="mainMenu"><bean:message key="goto.mainMenu"/></html:link>
