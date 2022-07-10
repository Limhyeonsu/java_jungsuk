package ch15;

import java.io.*;
import java.util.*;
/* SequenceInputStream : 여러개의 입력스트림을 연속적으로 연결해서 하나의 스트림으로부터 데이터를 읽는 것과 같이 처리
 * 큰 파일을 여러개로 나누었다가 하나의 파일로 합치는 작업을 할때 좋다.
 */
public class SequenceInputStreamEx {
	public static void main(String[] args) {
		byte[] arr1 = {0,1,2};
		byte[] arr2 = {3,4,5};
		byte[] arr3 = {6,7,8};
		byte[] outSrc = null;
		
		//vector에 연결할 입력스트림을 저장
		Vector v = new Vector();
		v.add(new ByteArrayInputStream(arr1));
		v.add(new ByteArrayInputStream(arr2));
		v.add(new ByteArrayInputStream(arr3));

		//elements()를 호출해서 생성자에 매개변수로 넣어준다.
		SequenceInputStream input = new SequenceInputStream(v.elements());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data = 0;
		
		try {
			while((data = input.read()) != -1) {
				output.write(data);
			}
		} catch (Exception e) {}
		
		outSrc = output.toByteArray();
		
		System.out.println("Input Source1 : "+ Arrays.toString(arr1));  //[0, 1, 2]
		System.out.println("Input Source2 : "+ Arrays.toString(arr2));  //[3, 4, 5]
		System.out.println("Input Source3 : "+ Arrays.toString(arr3));  //[6, 7, 8]
		System.out.println("Output Source : "+ Arrays.toString(outSrc));  //[0, 1, 2, 3, 4, 5, 6, 7, 8]
	}
}
