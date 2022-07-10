package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx3 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("Input Source : "+Arrays.toString(inSrc));
		
		try {
			//available() : 스트림으로부터 읽어 올 수 있는 데이터의 크기를 반환
			while(input.available() > 0) {  //true면 아직 읽어올 데이터가 있다
				input.read(temp);
				output.write(temp);
				
				outSrc = output.toByteArray();
				printArrays(temp, outSrc);
				/*temp : [0, 1, 2, 3]
				   Output Source : [0, 1, 2, 3]
				   temp : [4, 5, 6, 7]
				   Output Source : [0, 1, 2, 3, 4, 5, 6, 7]
				   temp : [8, 9, 6, 7]
				   Output Source : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 7]  
				   temp에 담긴 내용을 지우고 쓰는것이 아니라 덮어 씌우기 때문에 [4,5,6,7] -> [8,9,6,7]이 된다.
				   */
			}
		} catch (IOException e) {}
	}
	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp : "+Arrays.toString(temp));
		System.out.println("Output Source : "+Arrays.toString(outSrc));
	}
}
