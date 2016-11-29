<%@ include file="taglibs.jsp" %>

<html:errors/>
<html:form action="/logon.do" focus="userName" >
<center>
<table border="0" width="100%">

  <tr>
    <th align="right">
      <bean:message key="prompt.username"/>
    </th>
    <td align="left">
      <html:text property="userName" size="15" maxlength="15"/>
    </td>
  </tr>

  <tr>
    <th align="right">
      <bean:message key="prompt.password"/>
    </th>
    <td align="left">
      <html:password property="password" size="15" maxlength="15"
                    redisplay="false"/>
    </td>
  </tr>

  <tr>
    <td align="right">
    <html:submit property="submit" >                     
		<bean:message key="button.logon"/>
	</html:submit>

    </td>
    <td align="left">
    <html:reset >                     
		<bean:message key="button.reset"/>
	</html:reset>

    </td>
  </tr>

</table>
</center>
</html:form>



