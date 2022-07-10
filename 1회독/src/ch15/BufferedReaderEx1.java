package ch15;

import java.io.BufferedReader;
import java.io.FileReader;

/* BufferedReader / BufferedWriter : 버퍼를 이용해서 입출력의 효율을 높일 수 있도록 해주는 역할을 한다.
 * readLine() : 데이터를 라인단위로 읽음
 * newLine() : 줄바꿈 해줌
 */
public class BufferedReaderEx1 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			for (int i = 1; (line = br.readLine()) != null; i++) {
				//";"을 포함한 라인을 출력, 파일에서 특정문자 또는 문자열을 포함한 라인을 쉽게 찾아낼 수 있다.
				if(line.indexOf(";") != -1)
					System.out.println(i+":"+line);
				/*1:Hello, 안녕하세요?;
				   2:Hello, 안녕하세요?;
				   3:Hello, 안녕하세요?;
				   4:Hello, 안녕하세요?;
				   5:Hello, 안녕하세요?;
				 */
			}
			br.close();
		} catch (Exception e) {}
	}

}
