package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * java有四个元注解（就是注解的注解）{@Target, @Retention, @Docmented, @Inherted}
 * 作用如下：
 * @Target:表示该注解用在什么地方，可能值在枚举类ElementType中
 * ElementType.CONSTRUCTOR 构造器声明
 * ElementType.FIELD 域声明
 * ElementType.LOCAL_VARIABLE 局部变量声明
 * ElementType.METHOD 方法声明
 * ElementType.PACKAGE 包声明
 * ElementType.PARAMETER 参数声明
 * ElementType.TYPE 类、接口（包括注解类型）或enum声明
 * 
 * @Rentention表示在什么级别保存注解信息。可选参数在枚举类型RententionPolicy中
 * Rentention.SOURCE 注解在源代码中可用
 * Rentention.CLASS  注解在class文件中可用
 * Rentention.RUNTIME VM将在运行期也保留注释，因此可用通过反射机制读取注解信息。
 * 
 * @Documented将注解包含在javadoc中，它代表者此注解会被javadoc工具提成文档
 * 
 * @Inherited通常在父类中定义的注解并不会被子类继承，如果想被继承，可以通过调用
 * java.lang.annotation.Inherited，让定义的Annotation型别被继承下来。
 * 注意：注解继承只针对class级别注解有效。
 * */

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestA{
	/*
	 *  @interface用来声明一个注解
	 *  每一个方法实际上是声明了一个配置参数
	 * 	方法的名称就是参数的名称
	 * 	返回值类型就是参数类型 
	 * 	可以通过default来声明参数的默认值
	 * */
	/**
	 * @return
	 */
	String name();
	int id() default 0;
	Class<Long> gid();
}
