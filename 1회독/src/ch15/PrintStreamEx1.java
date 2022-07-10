package ch15;

import java.util.Date;

/* PrintStream : 데이터를 적절한 문자로 출력, 문자기반 스트림의 역할을 수행한다.
 * print, println, printf와 같은 메서드를 오버로딩하여 제공한다.
 * 향산된 기능의 PrintWriter가 추가되었고, PrintStream에 비해 다양한 언어의 문자를 처리하는데 적합하다.
 */
public class PrintStreamEx1 {
	public static void main(String[] args) {
		int i = 65;
		float f = 1234.56789f;
		
		Date d = new Date();
		
		System.out.printf("문자 %c의 코드는 %d%n", i, i);  //문자 A의 코드는 65
		System.out.printf("%d는 8진수로 %o, 16진수로 %x%n", i, i, i);  //65는 8진수로 101, 16진수로 41
		System.out.printf("%3d%3d%3d\n", 100, 90, 80); //100 90 80
		System.out.println();
		System.out.printf("123456789012345678901234567890%n");  //123456789012345678901234567890
		System.out.printf("%s%-5s%5s%n", "123", "123", "123");  //123123    123
		System.out.println();
		System.out.printf("%-8.1f%8.1f %e%n", f, f, f);  //1234.6    1234.6 1.234568e+03
		System.out.println();
		System.out.printf("오늘은 %tY년 %tm월 %td일 입니다. %n", d, d, d);  //오늘은 2021년 02월 27일 입니다. 
		System.out.printf("지금은 %tH시 %tM분 %tS초 입니다. %n", d, d, d);  //지금은 15시 19분 06초 입니다. 
		System.out.printf("지금은 %1$tH시 %1$tM분 %tS초 입니다. %n", d);  //지금은 15시 19분 06초 입니다.
	}
}
