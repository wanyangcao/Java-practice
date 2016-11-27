package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import sun.reflect.generics.scope.ConstructorScope;

public class ParseAnnotation{
	/*
	 * �÷�����ӡType���͵�ע��
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
	 * ��ӡmethod���͵�ע��
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
	 * �÷�����ӡ���췽�����͵�ע��
	 * 
	 * */
	public static void parseConstructorAnnotation() throws ClassNotFoundException {
		@SuppressWarnings("rawtypes")
		Constructor[] constructors = UserAnnotation.class.getConstructors();
		for(@SuppressWarnings("rawtypes") Constructor constructor : constructors) {
			//�жϹ��췽�����Ƿ���ָ��ע�����͵�ע��
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
	 * ��ӡfield���͵�ע��
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
		System.out.println("------------------------------����Typeע��----------------------------------------------------------");
        parseTypeAnnotation();
        System.out.println("------------------------------����Methodע��-------------------------------------------------------");
        parseMethodAnnotation();
        System.out.println("------------------------------�������췽��(Construct)ע��------------------------------------------");
        parseConstructorAnnotation();
        System.out.println("------------------------------�����ֶ�(Field)ע��-----------------------------------------------------");
        parseFieldAnnotation();
	}
}