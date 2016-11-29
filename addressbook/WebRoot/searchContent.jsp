
<%@ include file="taglibs.jsp" %>
<app:validateSession/>
<center>
<html:errors/>
<html:form action="/search.do" focus="title">
<table border="0" cellspacing="0" cellpadding="0">
	 <tr>
	 <td> <bean:message key="prompt.name"/></td>
	 <td>
	 	<html:text property="name" size="25" maxlength="25"/>
	 </td></tr>
	<tr>
	 	<td> <bean:message key="prompt.phone"/></td>
		 <td>
			<html:text property="phone" size="25" maxlength="10"/>
		 </td>
	 </tr>
	<tr>
		 <td> <bean:message key="prompt.address"/></td>
		 <td>
			<html:text property="address" size="25" maxlength="50"/>
		 </td>
	 </tr>
	 <tr>
	    <td align="right">
	      <html:submit property="submit" >                     
			<bean:message key="button.search"/>
		  </html:submit>

	      
	     </td>
	  <td align="left">
	  <html:reset  >                     
			<bean:message key="button.reset"/>
	   </html:reset>
	  </tr>
</table>
</html:form>
<html:link forward="mainMenu"><bean:message key="goto.mainMenu"/></html:link>
</center>
