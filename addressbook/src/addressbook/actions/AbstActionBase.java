package addressbook.actions;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import addressbook.Constants;
import addressbook.model.UserBean;

/**
 * This is the base class from which all Action classes that use
 * Struts can be derived from. It takes into consideration some
 * general architecture that would most likely be needed in a real
 * application. For the purpose of this sample application, those methods that
 * are not directly related to the Struts framework will be black-boxed
 * and commented so that you can use this as a skeleton and fill in those
 * methods as you see fit while you are doing development.
 * <p>All action classes need to be derived from org.apache.struts.action.Action
 * @see org.apache.struts.action.Action
 */
public abstract class AbstActionBase extends Action
{
	@SuppressWarnings("unused")
	private Log log =
        LogFactory.getLog(this.getClass().getName());

    /**
     * Default constructor
     */
    public AbstActionBase()
    {
    }

    /*
     * <strong>lookup</strong> is a blackbox method - lookup the EJB instance necessary.
     * Typically action classes
     * work with EJB session beans (or just JavaBeans) that contain the business logic for
     * your application. In large scale projects, you want to keep a clean
     * seperate of tier's. You would get the JNDI context, get an instance
     * of the context, and then do a lookup on the given JNDI name for the
     * EJB you are interested in to retrieve the home interface.
     * This is provide as just a sample of what is needed.
     * <p>Note: This method is not used in our application but included for
     * information purposes only. The JNDI context is usually specific to how the
     * application container requires its properties.
     *@param String containing JNDI name to lookup.
     *@return Object containing the home object looked up.
     *@throws NamingException if the name lookup fails
     *@throws MissingResourceException if can't get the resource bundle
     */

    public Object lookup(String jndiName) throws NamingException, MissingResourceException
    {
         Context jndiContext = null;

        //Set up the JNDI properties to get the initial context for calls to EJB objects
        if (jndiContext == null) {
            ResourceBundle resource = ResourceBundle.getBundle("addressbook.properties");
            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, resource.getString(Context.INITIAL_CONTEXT_FACTORY));
            properties.setProperty(Context.PROVIDER_URL, resource.getString(Context.PROVIDER_URL));
            properties.setProperty(Context.SECURITY_PRINCIPAL, resource.getString(Context.SECURITY_PRINCIPAL));
            properties.setProperty(Context.SECURITY_CREDENTIALS, resource.getString(Context.SECURITY_CREDENTIALS));
            jndiContext = new InitialContext(properties);
        }
         // Note: For production, you probably want a robust try/catch block here to log any errors
         // or important information. For this sample, any expceptions will just be thrown
         // and we'll return the home object.
        return (jndiContext.lookup(jndiName));

    }

    /**
     * Check to make sure that we have a valid session.
     * If the session is not valid, then forward to the Login page
     * @param HttpServletRequest
     * @return boolean valid session
     */
     public boolean isSessionValid(HttpServletRequest request){

     	if (request == null) return (false);
     	HttpSession session = request.getSession();
     	if (session == null) return(false);
     	// Checked for a currently logged on user
		UserBean user = (UserBean) session.getAttribute(Constants.USER_KEY);
		return ((user == null) ? false : true);
	}



	   @SuppressWarnings("unchecked")
	public Hashtable getDatabase(){
	   return((Hashtable) servlet.getServletContext().getAttribute(Constants.DATABASE_KEY));

	 }


    /**
     * This is the main action called from the Struts framework.
     * You can have this method call an abstract performAction method
     * that is then implemented by each action class and do any specifics
     * in this method that might be common to all actions, like logging.
     * For this example, we are simply using the execute as the asbstract method.
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     * @throws IOException if an input/output error occurs
     * @throws ServletException if a servlet exception occurs
     * @return ActionForwar - where control will be forwarded to after this request is processed
     */

    public abstract ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response) throws Exception;
        /*

    {
        // If you wanted to have another abstract method here, it is useful so that
        // you can do things such as logging, as shown below.
        ActionForward forward = null;
        // Simple log to the servlet log for informational purposes
        getServlet().log("AbstStrutsActionBase.execute() [Action Class: "+this.getClass().getName()+" ]");
        getServlet().log("AbstStrutsActionBase.execute() [Form Class : "+(form == null ? "null" : form.getClass().getName())+" ]");
   		// Or you can use the logging mechanism
   		if (log.isDebugEnabled()) {
			log.debug(AbstStrutsActionBase.execute() [Action Class: "+this.getClass().getName()+" ]");
			log.debug("AbstStrutsActionBase.execute() [Form Class : "+(form == null ? "null" : form.getClass().getName())+" ]");

		}

   		return(performAction(mapping, form, request, response));


    }
        */

}
