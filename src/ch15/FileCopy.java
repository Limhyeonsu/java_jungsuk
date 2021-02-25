package ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
	public static void main(String[] args) {
		try {
			//커맨드 창에 input.txt FileCopy.bak입력 -> input.txt파일의 내용이 FileCopy.bak으로 복사됨
			//텍스트 파일을 다루는 경우에응 FileStream보다 문자기반 스트림인 FileReader / FileWriter를 사용하는 것이 더 좋다
			FileInputStream fis = new FileInputStream(args[0]);
			FileOutputStream fos = new FileOutputStream(args[1]);
			
			int data = 0;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
