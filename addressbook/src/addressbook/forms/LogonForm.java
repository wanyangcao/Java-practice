
package addressbook.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
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
    private String userName = null;
    private String passWord = null;


    public String getuserName() {
		return (this.userName);
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }


    public String getpassWord() {
		return (this.passWord);
    }

    public void setpassWord(String passWord) {
        this.passWord = passWord;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.userName = null;
        this.passWord = null;

    }

    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
        if ((userName == null) || userName.trim().equals(""))
            errors.add("username", new ActionError("error.userName.required", userName));
        if ((passWord == null) || passWord.trim().equals(""))
            errors.add("password", new ActionError("error.passWord.required", passWord));

        return errors;

    }


}
