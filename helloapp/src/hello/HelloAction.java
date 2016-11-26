package hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

public final class HelloAction extends Action {

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
    throws Exception {

        // These "messages" come from the ApplicationResources.properties file
        @SuppressWarnings("unused")
		MessageResources messages = getResources(request);

      
        ActionErrors errors = new ActionErrors();
        String userName = (String)((HelloForm) form).getUserName();

        String badUserName = "Monster";

        if (userName.equalsIgnoreCase(badUserName)) {
           errors.add("username", new ActionError("hello.dont.talk.to.monster", badUserName ));
           saveErrors(request, errors);
           return (new ActionForward(mapping.getInput()));
        }

        PersonBean pb = new PersonBean();
        pb.setUserName(userName);
        pb.saveToPersistentStore();

        request.setAttribute( Constants.PERSON_KEY, pb);

       
        request.removeAttribute(mapping.getAttribute());
        return (mapping.findForward("sayHello"));

    }
}