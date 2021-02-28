package ch15;

import java.io.FileReader;
import java.io.FileWriter;

public class FileConversion {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(args[0]);
			FileWriter fw = new FileWriter(args[1]);
			
			int data = 0;
			while((data = fr.read()) != -1) {
				//파일의 공백을 모드 없애는 예제
				if(data != '\t' && data != '\n' && data != ' ' && data != '\r')
					fw.write(data);
			}
			fr.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
