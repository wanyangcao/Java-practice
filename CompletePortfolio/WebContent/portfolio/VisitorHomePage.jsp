<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>VisitorHomePage</title>
    <s:head/>
	</head>

	<body>
		<h4>Welcome to the Struts 2 Portfolio!</h4>
		
	
     <hr/>
	 	<h5>Browser Our Artists</h5>
	  
	      <a href="<s:url action='AjaxUserBrowser'/>">Artist Browser</a>
	
	  <hr/>
	 
	  <h5>View a Portfolio (JSP) </h5>
	  
	  <s:form action="ViewPortfolioJSP" >
			<s:doubleselect name="username" list='users' listKey="username" listValue="username" doubleName="portfolioName"  doubleList="portfolios" doubleListKey="value.name" doubleListValue="value.name" label="Select an artist and portfolio"  />  
			<s:submit value="View"/>
      </s:form>	
	
	  <hr/>
	  
	  	  <h5>View a Portfolio (Velocity) </h5>
	  
	  <s:form action="ViewPortfolioVM" >
			<s:doubleselect name="username" list='users' listKey="username" listValue="username" doubleName="portfolioName"  doubleList="portfolios" doubleListKey="value.name" doubleListValue="value.name" label="Select an artist and portfolio"  />  
			<s:submit value="View"/>
      </s:form>	
	
	  <hr/>
	  
	  	  <h5>View a Portfolio (FreeMarker)</h5>
	  
	  <s:form action="ViewPortfolioFM" >
			<s:doubleselect name="username" list='users' listKey="username" listValue="username" doubleName="portfolioName"  doubleList="portfolios" doubleListKey="value.name" doubleListValue="value.name" label="Select an artist and portfolio"  />  
			<s:submit value="View"/>
      </s:form>	
	
	  <hr/>

	</body>
	
</html>
