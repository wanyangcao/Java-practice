package manning.modelDriven;

import manning.utils.PortfolioService;
import manning.utils.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * This is our ModelDriven version of the Register action.  This action
 * implements the ModelDriven interface, which exposes the single getModel()
 * method which is used by the model driven interceptor to retrieve our 
 * User object for data transfer.  
 *   
 */

public class ModelDrivenRegister extends ActionSupport implements ModelDriven {

	public String execute() {

		getPortfolioService().createAccount(user);

		return SUCCESS;
	}

	/* Instance field and getModel() to support the ModelDriven interface */

	private User user = new User();

	public Object getModel() {

		return user;
	}

	public void validate() {

		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();

		/* Check that fields are not empty */
		if (user.getPassword().length() == 0) {
			addFieldError("password", getText("password.required"));
		}
		if (user.getUsername().length() == 0) {
			addFieldError("username", getText("username.required"));
		}
		if (user.getPortfolioName().length() == 0) {
			addFieldError("portfolioName", getText("portfolioName.required"));
		}
		/* Make sure user doesn't already have an account */
		if (ps.userExists(user.getUsername())) {
			addFieldError("username", getText("user.exists"));
		}

	}

	public PortfolioService getPortfolioService() {

		return new PortfolioService();

	}

}
