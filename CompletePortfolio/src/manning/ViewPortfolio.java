package manning;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import manning.utils.Portfolio;
import manning.utils.PortfolioService;
import manning.utils.User;

import com.opensymphony.xwork2.ActionSupport;

/*
 * This action retrieves the data model for viewing a particular portfolio. 
 */

public class ViewPortfolio extends ActionSupport implements SessionAware {

	public String execute(){
		
		/*
		 * Create and move the data onto our application domain object, user.
		 */
		portfolio = getPortfolioService().getPortfolio ( getUsername(), getPortfolioName() );
		session.put("sessionDataKey", "sessionDataValue");
		
		return SUCCESS;
	}

	/* JavaBeans Properties to Receive Request Parameters */
	
	private String username;
	private String portfolioName;
	private Portfolio portfolio;
	private Map session;

	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Portfolio getPortfolio(){
		return portfolio;
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
	
		if ( getUsername().length() == 0 ){			
			addFieldError( "username", getText("username.required") );
		}
		if ( getPortfolioName().length() == 0  ){			
			addFieldError( "portfolioName", getText( "portfolioName.required" ));
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
	public void setSession(Map session) {
	    this.session = session;
		
	}
	
	

}
