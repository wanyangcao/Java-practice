package manning.objectBacked;

import manning.utils.PortfolioService;
import manning.utils.User;

import com.opensymphony.xwork2.ActionSupport;

/*
 * This is our version of the Register action that uses object backed 
 * JavaBeans properties to receive the data transfer.  This classes uses
 * uses an application domain object, the user, as a JavaBeans property
 * in order to let the framework take over the tedious task of instantiating
 * the user object and assembling the individual datum onto it.  
 */

public class ObjectBackedRegister extends ActionSupport {

	public String execute() {

		getPortfolioService().createAccount(user);
		return SUCCESS;
	}

	/* JavaBeans Properties to Receive Request Parameters */

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void validate() {

		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();

		/* Check that fields are not empty */
		if (getUser().getPassword().length() == 0) {
			addFieldError("user.password", getText("password.required"));
		}
		if (getUser().getUsername().length() == 0) {
			addFieldError("user.username", getText("username.required"));
		}
		if (getUser().getPortfolioName().length() == 0) {
			addFieldError("user.portfolioName", getText("portfolioName.required"));
		}
		/* Make sure user doesn't already have an account */
		if (ps.userExists(getUser().getUsername())) {
			addFieldError("user.username", getText("user.exists"));
		}

	}

	public PortfolioService getPortfolioService() {

		return new PortfolioService();

	}

}
