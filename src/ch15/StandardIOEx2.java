package ch15;

import java.io.FileOutputStream;
import java.io.PrintStream;

/* setOut() : System.out 출력을 지정된 PrintStream으로 변경 
 * setErr() : System.err 출력을 지정된 PrintStream으로 변경
 * setIn() : System.in 출력을 지정된 PrintStream으로 변경
 * 위 세 메서드는 입출력을 콘솔 이외에 다른 입출력 대상으로 변경하는 것이 가능하다.
 */
public class StandardIOEx2 {
	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("test.txt");
			ps = new PrintStream(fos);
			System.setOut(ps); //System.out의 출력대상을 test.txt파일로 변경
					
		} catch (Exception e) {
			System.err.println("File not Found");
		}
		
		System.out.println("Hello by System.out");
		System.err.println("Hello by System.err");
	}
}
