
package addressbook.actions;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import addressbook.Constants;
import addressbook.model.UserBean;

/**
 * <strong>LogoffAction</strong> will log the user off of the
 * application. The <code>User</code> Object will be removed from
 * the session, and the session will be invalidated.
 */

@SuppressWarnings("unused")
public final class LogoffAction extends AbstActionBase {

	private Log log =
        LogFactory.getLog(this.getClass().getName());


    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {
 
    
	// Extract attributes we will need
	Locale locale = getLocale(request);
	MessageResources messages = getResources(request);

	HttpSession session = request.getSession();
	UserBean user = (UserBean) session.getAttribute(Constants.USER_KEY);

	// Process this user logoff and log something to the servlet
	// log so we can track users
	if (user != null) {

		if (log.isDebugEnabled()) {
		log.debug("LogoffAction: User [" + user.getUserName() +
	                    "] logged off in session " + session.getId());
		}

	}
	// Clean up the session for safe keeping, and then get rid of it
	session.removeAttribute(Constants.USER_KEY);
	session.invalidate();

	// Forward control to the Success URI
	return (mapping.findForward(Constants.FORWARD_SUCCESS));

    }


}
