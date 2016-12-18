package manning;


import manning.utils.PortfolioService;
import manning.utils.User;
import manning.utils.UserAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * This action just loads the data to prepopulate our update form. The data is retrieved
 * by letting the UserAware interface inject the user object that is kept in session
 * scope as a means of keeping track of whether a user is logged in or not.   
 */

public class UpdateAccountForm extends ActionSupport implements UserAware, ModelDriven {
	

	public String execute(){
		
		/* Since this is essentially and empty action that pass through to our
		 * update form, and the user data is already put in place by the UserAware
		 * interface, we don't need to do anything here.  
		 */
		return SUCCESS;
	}
	
	/*  
	 * Simple way to retrieve our business logic and data peristence
	 * object.  Late versions of the portfolio app will intergrate with
	 * more sophisticated technologies for these services.
	 */
	
	public PortfolioService getPortfolioService( ) 	{
		
		return new PortfolioService();
		
	}

	/* This is the UserAware interface that allows the AuthenticationIntercptor to inject
	 * the user object for a logged in user.  Since this action is in the secure package of 
	 * actions, we can safely assume that the user must be logged in.  
	 */
	
	private User user;
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() { 
		return user;
	}

	/* We know that the user is set already because the authentication interceptor
	 * is first in the stack.   
	 */
	public Object getModel() {
		return user;
	}
	
	

}
