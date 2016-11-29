package addressbook.actions;

import java.util.Hashtable;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import addressbook.Constants;
import addressbook.model.UserBean;
import addressbook.forms.LogonForm;

/**
 * <strong>LogonAction</strong> provides the login mechanism for the sample
 * application. The username/password pair that is entered by the user will be
 * compared against the database values that where read in at application
 * startup. An error will be reported if the username/password don't match,
 * otherwise a <code>User</code> Object will be inserted into the session to
 * indicate that the user is currently logged in.
 */

public final class LogonAction extends AbstActionBase {
	private Log log = LogFactory.getLog(this.getClass().getName());

	@SuppressWarnings({ "unused", "unchecked" })
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String userName = null;
		String password = null;

		Locale locale = getLocale(request);
		MessageResources messages = getResources(request);

		UserBean user = null;
		// Demonstrate a trace call to the logger
		if (log.isTraceEnabled()) {
			log.trace("LogonAction: entering method");
		}
		// Validate the request parameters specified by the user
		ActionErrors errors = new ActionErrors();
		if (form != null) {
			userName = ((LogonForm) form).getUserName();
			password = ((LogonForm) form).getPassword();
		}
		Hashtable database = (Hashtable) servlet.getServletContext()
				.getAttribute(Constants.DATABASE_KEY);
		if (database == null)
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionError(
					"error.database.missing"));
		else {
			user = (UserBean) database.get(userName);
			if ((user != null) && !user.getPassword().equals(password)) {
				user = null;
			}
			if (user == null)
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionError(
						"error.password.mismatch"));
		}

		// Report any errors we have discovered back to the original form
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (new ActionForward(mapping.getInput()));
		}

		// Save our logged-in user in the session
		HttpSession session = request.getSession();
		session.setAttribute(Constants.USER_KEY, user);
		// Demonstrate a debug call to the logger
		if (log.isDebugEnabled()) {
			log.debug("LogonAction: User '" + user.getUserName()
					+ "' logged on in session " + session.getId());
		}
		// Remove the obsolete form bean
		if (mapping.getAttribute() != null) {
			if ("request".equals(mapping.getScope()))
				request.removeAttribute(mapping.getAttribute());
			else
				session.removeAttribute(mapping.getAttribute());
		}

		// Forward control to the specified success URI
		return (mapping.findForward(Constants.FORWARD_SUCCESS));

	}

}
