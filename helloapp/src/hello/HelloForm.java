/*ActionForm 属于view的一部分，用于表单数据的验证*/
package hello;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public final class HelloForm extends ActionForm {

    private String userName = null;

    public String getUserName() {
        return (this.userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
   
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.userName = null;
    }
//    表单信息验证
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        if ((userName == null) || (userName.length() < 1) || userName == "")
            errors.add("username", new ActionError("hello.no.username.error"));
        return errors;
    }
}
