package database;

/*
 * 本例是一个简单的bean定义，
 * 并应用了之前创建的注解
 * */

@DBTable(name = "NUMBER")
public class Member{
	@SQLString(30) String firstName;
	@SQLString(50) String lastName;
	@SQLInteger Integer age;
	@SQLString(value = 30, constraints = @Constraints(primaryKey = true))
	String handle;
	static int memberCount;
	public String getHandle(){
		return handle;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String toString(){
		return handle;
	}
	public Integer getAge(){
		return age;
	}
}