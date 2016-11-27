package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import sun.reflect.generics.scope.ConstructorScope;

public class ParseAnnotation{
	/*
	 * 该方法打印Type类型的注解
	 * */
	public static void parseTypeAnnotation() throws ClassNotFoundException{
		Class clazz = Class.forName("annotation.UserAnnotation");
		Annotation[] annotations = clazz.getAnnotations();
		for(Annotation annotation : annotations) {
			TestA testA = (TestA) annotation;
			System.out.println("Type name = " + clazz.getName() + " | + id = " + testA.name()
			+ " | gid = " + testA.gid());
		}
	}
	/*
	 * 打印method类型的注解
	 * */
	public static void parseMethodAnnotation() throws ClassNotFoundException{
		Method[] methods = UserAnnotation.class.getDeclaredMethods();
		for(Method method : methods){
			boolean hasAnnotation = method.isAnnotationPresent(TestA.class);
			if(hasAnnotation){
				TestA annotation = method.getAnnotation(TestA.class);
				System.out.println("method name = " + method.getName() + "  |  id = " +
                        annotation.id() + "  |  description = " + annotation.name() +
                        "  |  gid = " + annotation.gid());
			}
		}
	}
	
	/*
	 * 该方法打印构造方法类型的注解
	 * 
	 * */
	public static void parseConstructorAnnotation() throws ClassNotFoundException {
		@SuppressWarnings("rawtypes")
		Constructor[] constructors = UserAnnotation.class.getConstructors();
		for(@SuppressWarnings("rawtypes") Constructor constructor : constructors) {
			//判断构造方法中是否有指定注解类型的注解
			boolean hasAnnotation = constructor.isAnnotationPresent(TestA.class);
			if(hasAnnotation){
				@SuppressWarnings("unchecked")
				TestA annotation = (TestA) constructor.getAnnotation(TestA.class);
				System.out.println("constructor = " + constructor.getName()  
                + "   |   id = " + annotation.id() + "  |  description = "  
                + annotation.name() + "  |   gid= "+annotation.gid());
			}
		}
	}
	
	/*
	 * 打印field类型的注解
	 * */
	public static void parseFieldAnnotation() throws ClassNotFoundException{
		Field[] fields = UserAnnotation.class.getDeclaredFields();
		for(Field field : fields){
			boolean hasAnnotation = field.isAnnotationPresent(TestA.class);
            if(hasAnnotation){
                TestA annotation = field.getAnnotation(TestA.class);
                System.out.println("Field = " + field.getName()  
                        + "  |  id = " + annotation.id() + "  |  description = "  
                        + annotation.name() + "  |  gid= "+annotation.gid());
            }
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException{
		System.out.println("------------------------------解析Type注解----------------------------------------------------------");
        parseTypeAnnotation();
        System.out.println("------------------------------解析Method注解-------------------------------------------------------");
        parseMethodAnnotation();
        System.out.println("------------------------------解析构造方法(Construct)注解------------------------------------------");
        parseConstructorAnnotation();
        System.out.println("------------------------------解析字段(Field)注解-----------------------------------------------------");
        parseFieldAnnotation();
	}
}