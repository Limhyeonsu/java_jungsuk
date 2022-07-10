package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx2 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		//read(byte[] temp, int off, int n) : 최대 n개의 byte를 읽어서 배열 temp에 지정된 위치(off)부터 저장한다.
		//배열을 이용한 입출력은 작업의 효율을 증가 시킨다.
		input.read(temp, 0, temp.length);  //읽어온 데이터를 배열 temp에 담는다.
		output.write(temp, 5, 5);  //temp[5]부터 5개의 데이터를 write한다.
		
		outSrc = output.toByteArray();  //스트림의 내용을 byte 배열로 반환
		
		System.out.println("Input Source : "+Arrays.toString(inSrc));
		System.out.println("temp : "+Arrays.toString(temp));
		System.out.println("Output Source : "+Arrays.toString(outSrc));
	}
}
