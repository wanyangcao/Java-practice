package addressbook.actions;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.util.MessageResources;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import addressbook.Constants;

/**
 * <strong>DisplayAllAction</strong> is used to display all
 * of the current CD's in the database. The SQL string is created
 * and then we forward to the appropriate View. The session attribute
 * <code>Globals.SQLSTMT_KEY</code> is used to store the SQL statement.
 * Another entirely possible approach would have been to have a DAO object
 * that makes the database query and then stored the result set in the session
 * for the View to use. Since we are using another custom tag for demonstrating
 * features in this application, I choose the approach of storing the SQL statement instead.
 */
@SuppressWarnings("unused")
public final class DisplayAllAction extends AbstActionBase {

	private Log log =
        LogFactory.getLog(this.getClass().getName());

    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {

	
		Locale locale = getLocale(request);
		MessageResources messages = getResources(request);

		ActionErrors errors = new ActionErrors();

		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		    return (new ActionForward(mapping.getInput()));
		}

		String strSql = new String("SELECT * FROM " + Constants.TABLENAME + " ORDER BY NAME");
	        HttpSession session = request.getSession();
		session.setAttribute(Constants.SQLSTMT_KEY, strSql);

		return (mapping.findForward(Constants.FORWARD_SUCCESS));

    }
}
