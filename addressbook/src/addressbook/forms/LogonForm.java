
package addressbook.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


/**
 * <strong>LogonForm</strong> handles the form
 * that the user will use to logon to the application.
 */

@SuppressWarnings("serial")
public final class LogonForm extends ActionForm {
    private String username = null;
    private String password = null;


    public String getUserName() {
		return (this.username);
    }

    public void setUserName(String username) {
        this.username = username;
    }


    public String getPassword() {
		return (this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.username = null;
        this.password = null;

    }

    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
        if ((username == null) || username == "" || (username.length() < 1))
            errors.add("username", new ActionMessage("error.username.required"));
        if ((password == null) || username == "" ||  (password.length() < 1))
            errors.add("password", new ActionMessage("error.password.required"));

        return errors;

    }


}
