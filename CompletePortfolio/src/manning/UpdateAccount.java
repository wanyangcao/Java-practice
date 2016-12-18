package manning;


import manning.utils.PortfolioService;
import manning.utils.User;
import manning.utils.UserAware;

import com.opensymphony.xwork2.ActionSupport;



public class UpdateAccount extends ActionSupport implements UserAware {
	

	public String execute(){
		
		/*
		 * Move the new, already validated data onto our application domain object, user, and persist that user.
		 */
		
		PortfolioService service = getPortfolioService();
		
		user.setPassword( getPassword() );
		user.setReceiveJunkMail( isReceiveJunkMail());
		user.setUsername( getUsername() );
		
		getPortfolioService().persistUser( user );
		
		return SUCCESS;
		
	}
	
	
	/* JavaBeans Properties to Receive Request Parameters */
	
	private String username;
	private String password;
	public boolean receiveJunkMail;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isReceiveJunkMail() {
		return receiveJunkMail;
	}
	public void setReceiveJunkMail(boolean receiveJunkMail) {
		this.receiveJunkMail = receiveJunkMail;
	}
	
	/* Validateable Implmentation 
	 * 
	 * The validate method validates, invoked by the validation intercptor in
	 * the default stack, will validate the data already set on the action
	 * by the params interceptor, also in the default stack.  
	 * 
	 * If this method finds problems in validation it stores error messages via
	 * the methods exposed by the ValidationAware interface -- already implemented
	 * by the ActionSupport class that this action extends.  To complete the 
	 * the validation process, the workflow interceptor fires next in the default
	 * stack.  It checks for error messages on the action, and if it finds them 
	 * it diverts workflow back to the input page where the error messages are 
	 * displayed to the user.  In this case, the execute method of the action
	 * will not be called because the workflow was diverted, due to validation
	 * problems, before execution reached the action itself.
	 * 
	 * */
	
	public void validate(){
		
		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();
		
		/* Check that fields are not empty */
		if ( getPassword().length() == 0 ){			
			addFieldError( "password", getText("password.required") );
		}
		if ( getUsername().length() == 0 ){			
			addFieldError( "username", getText("username.required") );
		}
	
	}
	
	/*  
	 * Simple way to retrieve our business logic and data peristence
	 * object.  Late versions of the portfolio app will intergrate with
	 * more sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService( ) 	{
		
		return new PortfolioService();
		
	}
	
	private User user;
	
	public void setUser(User user) {
	
		this.user = user;
		
	}
	
	

}
