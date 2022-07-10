package ch15;

import java.io.FileInputStream;
import java.io.IOException;
/* FileInputStream, FileOutputStream 파일에 입출력을 하기 위한 ㅅ트림.
 * 
 */
public class FileViewer {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream(args[0]);
		int data = 0;
		//read()의 반환값이 int형이지만 0~255범위의 정수값이기 때문에 char형으로 변환해도 손실값X
		 while((data = fis.read()) != -1) {
			 char c = (char)data;
			 System.out.print(c);
		 }
	}
}
