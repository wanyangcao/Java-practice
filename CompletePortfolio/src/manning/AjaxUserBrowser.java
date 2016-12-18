package manning;

import java.util.Collection;

import manning.utils.PortfolioService;
import manning.utils.User;

import com.opensymphony.xwork2.ActionSupport;

/*
 * This action retrieves the data model for building a select box of users.
 * This mostly consists of a list of the current user/accounts. 
 */

public class AjaxUserBrowser extends ActionSupport {

	public String execute() {
		Collection users = getPortfolioService().getUsers();
		setUsers(users);

		String selectedUsername = getPortfolioService().getDefaultUser();
		setDefaultUser(getPortfolioService().getUser(selectedUsername));

		return SUCCESS;
	}

	/* JavaBeans Properties to Receive Request Parameters */

	private Collection users;
	private User defaultUser;

	public Collection getUsers() {
		return users;
	}

	public void setUsers(Collection users) {
		this.users = users;
	}

	public User getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(User username) {
		this.defaultUser = username;
	}

	/*
	 * Simple way to retrieve our business logic and data persistence object.
	 * Late versions of the portfolio app will integrate with more
	 * sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService() {

		return new PortfolioService();

	}

}
