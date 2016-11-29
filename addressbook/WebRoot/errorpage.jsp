<%@ page isErrorPage="true" %>
<p>
<h3>The following error occurred in your AddressBook Sample Application:</h3>
<br>
<hr>

<p><font color="red" size=4>

<%
	String message = "Unknown Error: Please report to your administrator."; 
	if (exception != null ){
		message = ((Exception)exception).getMessage();
	}
   
       out.println(message);
 
%>
</font>
<br>
</p>






	
