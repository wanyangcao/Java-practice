package database;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class TableCreator{
	public static void main(String[] args) throws ClassNotFoundException{
		if(args.length < 1){
			System.out.println("Arguments: Annotated classes");
			System.exit(0);
		}
		for(String className : args){
			Class<?> cl = Class.forName(className);
			DBTable dbTable = cl.getAnnotation(DBTable.class);
			if(dbTable == null){
				System.out.println("No DBTable annotation in class" + className);
				continue;
			}
			String tableName = dbTable.name();
			if(tableName.length() < 1){
				tableName = cl.getName().toUpperCase();
			}
			List<String> columnDefs = new ArrayList<String>();
			for(Field field : cl.getDeclaredFields()){
				String columnName = null;
				Annotation[] annotations = field.getDeclaredAnnotations();
				if(annotations.length < 1){
					continue;
				}
				if(annotations[0] instanceof SQLInteger){
					SQLInteger sqlInteger = (SQLInteger) annotations[0];
					if(sqlInteger.name().length() < 1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sqlInteger.name();
					columnDefs.add(columnName + " INT" + getConstrains(sqlInteger.constraints()));
				}
				
			}
			StringBuilder creatCommand = new StringBuilder(
					"CREATE TABLE " + tableName + "(");
			for(String columnDef : columnDefs){
				creatCommand.append("\n  " + columnDef + ".");
			}
		}
		
	}
	private static String getConstrains(Constraints con){
		String constraints = "";
		if(!con.allowNull()){
			constraints += " NOT NULL";
		}
		if(con.primaryKey())
			constraints += " PRIMARY KEY";
		if(con.unique())
			constraints += " UNIQUE";
		return constraints;
	}
}