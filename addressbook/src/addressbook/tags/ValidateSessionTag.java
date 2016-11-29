package addressbook.tags;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import addressbook.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <strong>ValidateSessionTag</strong> is a custom tag used
 * with this application to determine is a user has a current
 * validate session.
 */

@SuppressWarnings("serial")
public final class ValidateSessionTag extends TagSupport {
    private String name = Constants.USER_KEY;
    private String page = Constants.LOGON_JSP;
    @SuppressWarnings("unused")
	private Log log =LogFactory.getLog(this.getClass().getName());

    public int doEndTag() throws JspException {
	boolean valid = false;
	HttpSession session = pageContext.getSession();
	if ((session != null) && (session.getAttribute(name) != null))
	    valid = true;

	if (valid)
	    return (EVAL_PAGE);
	else {
	    try {
		pageContext.forward(page);
	    } catch (Exception e) {
		throw new JspException(e.toString());
	    }
	    return (SKIP_PAGE);
	}
    }
    public int doStartTag() throws JspException {
	return (SKIP_BODY);
    }
    public String getName() {
	return (this.name);
    }
    public String getPage() {
	return (this.page);
    }
    public void release() {
        super.release();
        this.name = Constants.USER_KEY;
        this.page = Constants.LOGON_JSP;
    }
    public void setName(String name) {
	this.name = name;
    }
    public void setPage(String page) {
	this.page = page;
    }
}
