package addressbook;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import org.apache.commons.digester.Digester;
import addressbook.model.UserBean;

@SuppressWarnings("serial")
public final class UserDatabaseServlet
    extends HttpServlet {

    @SuppressWarnings("unchecked")
	private Hashtable database = null;

    private int debug = 0;

    private String pathname = "/WEB-INF/userdatabase.xml";

    public void destroy() {

	getServletContext().removeAttribute(Constants.DATABASE_KEY);

    }

    public int getDebug() {
		return (this.debug);
    }

    @SuppressWarnings("unchecked")
	public void addUser(UserBean user){
        database.put(user.getUserName(),user);
    }
   public void init() throws ServletException {

	String value;
	value = getServletConfig().getInitParameter("debug");
	try {
	    debug = Integer.parseInt(value);
	} catch (Throwable t) {
	    debug = 0;
	}
	if (debug >= 1)
	    log("Initializing database servlet");
        value = getServletConfig().getInitParameter("pathname");
        if (value != null)
            pathname = value;

	try {
	
	    load();
	    getServletContext().setAttribute(Constants.DATABASE_KEY,
					     database);
	} catch (Exception e) {
	    log("Database load exception", e);
	    throw new UnavailableException
		("Cannot load database from '" + pathname + "'"+e.getMessage());
	}

    }


    /**
     * Load the current database.xml file. Using the <code>Digester<code>
     * @see org.apache.commons.digester.Digester
     */


    @SuppressWarnings({ "deprecation", "unchecked" })
	private synchronized void load() throws Exception {


	database = new Hashtable();

	if (debug >= 1) log("Loading database from '" + pathname + "'");
   	InputStream is = getServletContext().getResourceAsStream(pathname);
   	if (is == null) {
       log("No such resource available - loading empty database");
       return;
   	}
	BufferedInputStream bis = new BufferedInputStream(is);
	Digester digester = new Digester();
	digester.push(this);
	digester.setDebug(debug);
	digester.setValidating(false);
	digester.addObjectCreate("database/user", "addressbook.model.UserBean");
	digester.addSetProperties("database/user");
	digester.addSetNext("database/user", "addUser");

	digester.parse(bis);
	bis.close();

    }
}
