package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * java���ĸ�Ԫע�⣨����ע���ע�⣩{@Target, @Retention, @Docmented, @Inherted}
 * �������£�
 * @Target:��ʾ��ע������ʲô�ط�������ֵ��ö����ElementType��
 * ElementType.CONSTRUCTOR ����������
 * ElementType.FIELD ������
 * ElementType.LOCAL_VARIABLE �ֲ���������
 * ElementType.METHOD ��������
 * ElementType.PACKAGE ������
 * ElementType.PARAMETER ��������
 * ElementType.TYPE �ࡢ�ӿڣ�����ע�����ͣ���enum����
 * 
 * @Rentention��ʾ��ʲô���𱣴�ע����Ϣ����ѡ������ö������RententionPolicy��
 * Rentention.SOURCE ע����Դ�����п���
 * Rentention.CLASS  ע����class�ļ��п���
 * Rentention.RUNTIME VM����������Ҳ����ע�ͣ���˿���ͨ��������ƶ�ȡע����Ϣ��
 * 
 * @Documented��ע�������javadoc�У��������ߴ�ע��ᱻjavadoc��������ĵ�
 * 
 * @Inheritedͨ���ڸ����ж����ע�Ⲣ���ᱻ����̳У�����뱻�̳У�����ͨ������
 * java.lang.annotation.Inherited���ö����Annotation�ͱ𱻼̳�������
 * ע�⣺ע��̳�ֻ���class����ע����Ч��
 * */

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestA{
	/*
	 *  @interface��������һ��ע��
	 *  ÿһ������ʵ������������һ�����ò���
	 * 	���������ƾ��ǲ���������
	 * 	����ֵ���;��ǲ������� 
	 * 	����ͨ��default������������Ĭ��ֵ
	 * */
	/**
	 * @return
	 */
	String name();
	int id() default 0;
	Class<Long> gid();
}
