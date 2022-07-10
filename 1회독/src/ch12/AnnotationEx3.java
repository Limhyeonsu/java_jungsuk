package ch12;
/* 애너테이션 직접 만들어보기
 * 애너테이션의 요소는 반환 값이 있고, 매개변수는 없는 추상메서드의 형태를 가진다.
 * 애너테이션을 적용할 때 요소들의 값을 빠짐없이 지정해주어야 한다.
 * 기본 값을 가질 수 있으며, 기본 값을 가지고 있응 요소는 값을 지정하지 않는 경우 기본값이 사용된다.
 * 애너테이션의 요소가 하나뿐이고 이름이 value인 경우 애너테이션 적용시 요소의 이름 생략가능
 * 요소가 하나도 정의되지 않은 애너테이션 => 마커 애너테이션 
 */

import java.lang.annotation.*;

@Deprecated
@SuppressWarnings("1111") //유효하지 않은 애너테이션은 무시된다.
@TestInfo(testBy = "aaa", testDate = @DateTime(yymmdd = "210210", hhmmss = "215759"))
public class AnnotationEx3 {
	public static void main(String[] args) {
		Class<AnnotationEx3> cls = AnnotationEx3.class;
		
		TestInfo anno = (TestInfo)cls.getAnnotation(TestInfo.class);
		System.out.println("anno.testBy() = "+anno.testBy());
		System.out.println("anno.testDate().yymmdd() = "+anno.testDate().yymmdd());
		System.out.println("anno.testDate().hhmmss() = "+anno.testDate().hhmmss());
		
		for(String str : anno.testTools())
			System.out.println("testTools = "+str);
		
		System.out.println();
		
		Annotation[] annoArr = cls.getAnnotations();
		
		for(Annotation a : annoArr)
			System.out.println(a);

	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo{
	int count() default 1;
	String testBy();
	String[] testTools() default "JUnit";
	TestType testType() default TestType.FIRST;
	DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime{
	String yymmdd();
	String hhmmss();
}

enum TestType {FIRST, FINAL}
