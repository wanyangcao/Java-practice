<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html locale="true">
  <head>
    <title><bean:message key="hello.jsp.title"/></title>
    <html:base/>
  </head>
  <body bgcolor="white"><p>

    <h2><bean:message key="hello.jsp.page.heading"/></h2>
    <p><html:errors/><p> 
    <logic:present name="personbean" scope="request">
       <h2>
         <bean:message key="hello.jsp.page.hello"/>
         <bean:write name="personbean" property="userName"/>
       </h2>
    </logic:present>

    <html:form action="/hello.do" focus="userName" >

      <bean:message key="hello.jsp.prompt.person"/>
      <html:text property="userName" size="16" maxlength="16"/><br>

      <html:submit property="submit" value="Submit"/>
      <html:reset/>

    </html:form><br>

    <html:img page="/struts-power.gif" alt="Powered by Struts"/>

  </body>
</html:html>
