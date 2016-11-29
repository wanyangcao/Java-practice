package addressbook;

/**
 * <strong>Constants</strong> holds all of the global constants used throughout
 * the AddressBook application
 */
public final class Constants {
	// Session keys
    public static final String DATABASE_KEY = "database";
    public static final String USER_KEY = "user";
    public static final String SQLSTMT_KEY = "sqlstatement";

    
    //Forward values
    public static final String FORWARD_SUCCESS = "success";
    public static final String FORWARD_FAILURE = "failure";
    public static final String FORWARD_ERROR = "error";
    public static final String FORWARD_CONFIRMATION = "confirmation";
    public static final String FORWARD_INSERT = "insert";

   
    // JSP files references in this application
    public static final String DISPLAY_JSP = "/display.jsp";
    public static final String INDEX_JSP = "/index.jsp";
    public static final String LOGOFF_JSP = "/logoff.jsp";
    public static final String LOGON_JSP = "/logon.jsp";
    public static final String MAINMENU_JSP = "/mainMenu.jsp";
    public static final String SEARCH_JSP = "/search.jsp";
    
    // Database table name used for this sample
    public static final String TABLENAME = "ADDRESSBOOK_TABLE";
    public static final String TABLECOL1 = "NAME";
    public static final String TABLECOL2 = "PHONE";
    public static final String TABLECOL3 = "ADDRESS";
    

}
