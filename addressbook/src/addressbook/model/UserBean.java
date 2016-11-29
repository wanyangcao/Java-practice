package addressbook.model;

import java.io.Serializable;

/**
 * <strong>UserBean</strong> will hold all of the information
 * regarding a specific user of the AddressBook application.
 */
@SuppressWarnings("serial")
public final class UserBean implements Serializable {


    private String password = null;
    private String userName = null;
   // Getter/Setter methods for all defined properties

    public String getPassword() {

	return (password);

    }
   public String getUserName() {

	return (userName);

    }
    public void setPassword(String password) {

	this.password = password;

    }
    public void setUserName(String userName) {

	this.userName = userName;

    }

    public String toString() {

        StringBuffer sb = new StringBuffer("User[username=" + userName + "]");
        return (sb.toString());

    }
}
