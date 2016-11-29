package addressbook.model;

import java.sql.*;

/**
 * <strong>DbUtil</strong> is a utility class to create
 * a connection to our sample database.
 */
public class DbUtil {
	//���õ�Ϊmysql����ͬ���ݿ���Ҫ����Ӧ����
	static String driverName="com.mysql.jdbc.Driver";
	static String dbUrl="jdbc:mysql://";

public DbUtil() {

}

public static java.sql.Connection connectToDb(String hostName, String databaseName)throws Exception
{
        Connection connection=null;
        String connName = dbUrl + hostName+":3306" + "/" +databaseName;
	    Class.forName(driverName).newInstance();
        connection = DriverManager.getConnection(connName,"root","123456");  
        
        return connection;
}

public static java.sql.Connection connectToDb(String databaseName)throws Exception{
	return(connectToDb("localhost", databaseName));
}

public static java.sql.Connection connectToDb()throws Exception{
	return(connectToDb("localhost", "test"));   //testΪ�Լ������ݿ�����
}


}
