package addressbook.actions;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import addressbook.forms.InsertForm;
import addressbook.model.AddressBookBean;
import addressbook.Constants;

/**
 * <strong>InsertAction</strong> inserts a new record into the database.
 */
@SuppressWarnings("unused")
public final class InsertAction extends AbstActionBase {

	private Log log =
        LogFactory.getLog(this.getClass().getName());

    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {
       
        

	Locale locale = getLocale(request);
	MessageResources messages = getResources(request);
  
	String name=null;
	String phone=null;
	String address=null;

	ActionErrors errors = new ActionErrors();
       name = ((InsertForm) form).getName();
       phone=((InsertForm)form).getPhone();
       address=((InsertForm)form).getAddress();

      try
      {
              AddressBookBean bean=new AddressBookBean(name,phone,address);
              bean.insert();
      }
      catch(Exception ex)
      {
              ex.printStackTrace(System.out);
              errors.add(ActionMessages.GLOBAL_MESSAGE,
                           new ActionMessage("error.insert.failed"));
      }

      if (!errors.isEmpty()) {
          saveErrors(request, errors);
          return (new ActionForward(mapping.getInput()));
      }
      // If we had no errors, then add a confirmation message
      ActionMessages actionMessages = new ActionMessages();
      actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("record.inserted"));
      saveMessages(request,actionMessages);

      return (mapping.findForward(Constants.FORWARD_CONFIRMATION));

    }
}
