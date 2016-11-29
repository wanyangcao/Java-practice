package addressbook.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * <strong>InsertForm</strong> handles the form
 * that the user will use to insert a new Address into
 * the database.
 */

@SuppressWarnings("serial")
public final class InsertForm extends ActionForm {
    private String name = null;
    private String phone = null;
    private String address = null;


public String getName() {
	return name;
}
public String getPhone() {
	return phone;
}
public String getAddress() {
	return address;
}

public void reset(ActionMapping mapping, HttpServletRequest request) {
   name = null;
   phone = null;
   address = null;
}


public void setName(String name) {
	this.name = name;
}
public void setPhone(String phone) {
	this.phone= phone;
}
public void setAddress(String address) {
	this.address = address;
}

public ActionErrors validate(ActionMapping mapping,
                             HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
        if (((name == null) || (name.length() < 1)))
            errors.add("name", new ActionMessage("error.name.required"));
        if(((phone == null)|| (phone.length() < 1)))
            errors.add("phone", new ActionMessage("error.phone.required"));
        if(((address == null)|| (address.length() < 1)))
            errors.add("address", new ActionMessage("error.address.required"));

        return errors;

    }
}
