
package addressbook.tags;

import java.util.Vector;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspTagException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import addressbook.model.AddressBookBean;
import addressbook.Constants;

@SuppressWarnings("serial")
public final class DisplayTag extends TagSupport {

	@SuppressWarnings("unused")
	private Log log =
        LogFactory.getLog(this.getClass().getName());


@SuppressWarnings("unchecked")
public int doEndTag() throws JspException
{
	JspWriter out = pageContext.getOut();
        HttpSession session = pageContext.getSession();
	try
	{

		String strSql=(String)session.getAttribute(Constants.SQLSTMT_KEY);
		Vector addressBookBeans=AddressBookBean.search(strSql);

                out.println("<table border=\"2\" cellspacing=\"0\" cellpadding=\"0\">");
                out.println("<tr>");
                out.println("<th BGCOLOR=\"yellow\"><b>姓名</b></th>");
                out.println("<th BGCOLOR=\"yellow\"><b>电话</b></th>");
                out.println("<th BGCOLOR=\"yellow\"><b>地址</b></th>");
                out.println("</tr>");

                for(int i=0;i<addressBookBeans.size();i++)
                {
                        AddressBookBean bean=(AddressBookBean)addressBookBeans.elementAt(i);
                        out.println("<tr>");
                        out.println("<td>"+ bean.getName() + "</td>");
                        out.println("<td>"+ bean.getPhone() + "</td>");
                        out.println("<td>"+ bean.getAddress()+"</td>");
                }

                out.println("</table>");


  }catch (Exception ex)
	{
	  throw new JspTagException("IOException:" + ex.toString());
	}
 	return super.doEndTag();
}
}
