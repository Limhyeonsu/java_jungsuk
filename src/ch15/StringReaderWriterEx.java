package ch15;

import java.io.StringReader;
import java.io.StringWriter;

/* StringReader / StringWriter : CharArrayReader, Writer와 같이 입출력대상이 메모리인 스트림
 * StringWriter에 출력되는 데이터는 내부의 StringBuffer에 저장되고 getBuffer()를 사용하여 StringBuffer를 반환
 */
public class StringReaderWriterEx {
	public static void main(String[] args) {
		String inputData = "ABCD";
		StringReader input = new StringReader(inputData);
		StringWriter output = new StringWriter();
		
		int data = 0;
		
		try {
			while((data = input.read()) != -1) {
				System.out.print(data); //65 66 67 68
				output.write(data);
			}
		} catch (Exception e) {}
		System.out.println("Input Data : "+inputData);
		System.out.println("Output Data : "+output.toString());
		System.out.println("Output Data : "+output.getBuffer().toString());
	}
}
