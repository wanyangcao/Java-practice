package manning;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

/*
 *This action doesn't really do anything.  We will hit a dispatcher result that
 *forwards to another servlet in this web application, outside of Struts 2.
 */

public class ForwardToAnotherServlet extends ActionSupport implements
		RequestAware {

	public String execute() {

		/*
		 * We will set a request attribute just to show that we can retrieve it
		 * from the external servlet since its still processing the same
		 * request, as per the Servlet API's definition of how the
		 * RequestDispatcher works; the dispatcher result type uses the
		 * RequestDispatcher internally. We will retrieve some data in
		 * AnotherServlet to show what data is still available to us in the
		 * forwarded servlet.
		 */

		/*
		 * We will put something in the request map, which is the Struts 2
		 * interface to the request objects attributes.
		 */
		getRequest().put("attributeSetInS2Action",
				"Hello from a request attribute set in the S2 Action");

		return SUCCESS;
	}

	private Map request;

	public void setRequest(Map request) {
		this.request = request;

	}

	public Map getRequest() {
		return request;
	}

	public String getTestProperty() {
		return "myValueFromActionProperty";
	}

}
