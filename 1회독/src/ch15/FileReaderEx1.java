package ch15;

import java.io.FileInputStream;
import java.io.FileReader;

/* 문자기반 스트림
 * Reader, Writer : byte배열 대신 char 배열을 사용한다.
 * 인코딩->유니코드 / 유니코드 ->인코딩 변환을 자동으로 해준다.
 * FileReader / FileWriter 파일로부터 텍스트데이터를 읽고, 파일에 쓰는데 사용된다.
 */
public class FileReaderEx1 {
	public static void main(String[] args) {
		try {
			String fileName = "test.txt";
			FileInputStream fis = new FileInputStream(fileName);
			FileReader fr = new FileReader(fileName);
			
			int data = 0;
			
			//FileInputStream을 이용해서 파일의 내용을 읽어온다. 한글이 깨져서 출력됨
			while((data = fis.read()) != -1) {
				System.out.print((char)data);  //Hello, ìëíì¸ì?
			}
			System.out.println();
			fis.close();
			
			//FileReader를 이용해서 파일의 내용을 읽어온다.
			while((data = fr.read()) != -1)
				System.out.print((char)data);  //Hello, 안녕하세요?
			System.out.println();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
