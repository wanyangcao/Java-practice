package annotation;
import java.util.HashMap;
import java.util.Map;

/*
 * ²âÊÔ×¢½â
 * */

@TestA(name = "type", gid = Long.class)
public class UserAnnotation{
	@TestA(name = "param", id = 1, gid = Long.class)
	private Integer age;
	
	@TestA(name = "construct", id = 2, gid = Long.class)
	public UserAnnotation(){
		
	}
	
	@TestA(name = "public method", id = 3, gid = Long.class)
	public void a(){
		Map map = new HashMap(0);
	}
	@TestA(name = "protected method", id = 4, gid = Long.class)
	protected void b(){
	}
	@TestA(name = "private method", id = 5, gid = Long.class)
	private void c(){
		
	}
}