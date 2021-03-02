package ch15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* InputStreamReader / OutputStreamWriter
 * 바이트기반 스트림을 문자기반 스트림으로 연결시켜주는 역할
 * 바이트기반 스트림의 데이터를 지정된 인코딩의 문자데이터로 변환하는 작업을 수행
 */
public class InputStreamReaderEx {
	public static void main(String[] args) {
		String line = "";
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("사용중인 OS의 인코딩 : "+isr.getEncoding());  //사용중인 OS의 인코딩 : UTF8
			
			do {
				System.out.println("문장을 입력하세요. 마치시려면 q를 입력하세요.>");
				//readLine()을 이용해서 사용자의 화면입력을 라인단위로 입력받기 편하다. JDK1.5부터는 Scanner사용
				line = br.readLine();
				System.out.println("입력하신 문자 : "+line);
			}while(!line.equalsIgnoreCase("q"));
			//System.in과 같은 표준입출력은 닫지 않아도 된다.
			System.out.println("프로그램을 종료합니다.");
		} catch (Exception e) {}
	}
}
