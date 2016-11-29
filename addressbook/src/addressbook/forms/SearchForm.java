package addressbook.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


/**
 * <strong>SearchForm</strong> handles the form
 * that the user will use to search the database.
 */

@SuppressWarnings("serial")
public final class SearchForm extends ActionForm {

    private String name = null;
    private String phone = null;
    private String address = null;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


public void reset(ActionMapping mapping, HttpServletRequest request) {

   this.name = null;
   this.phone = null;
   this.address=null;

}
public ActionErrors validate(ActionMapping mapping,
                             HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
        if (
	        ((name == null) || (name.length() < 1))
	        &&((phone == null)|| (phone.length() < 1))
	        &&((address == null) || (address.length() < 1))
	        )
            errors.add("search", new ActionMessage("error.searchcriteria.required"));
        return errors;

    }
}
