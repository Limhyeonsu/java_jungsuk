package ch15;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Arrays;

/* DataOutputStream 사용시 이진데이터로 저장되기 때문에 글자가 깨져서 보인다.
 * 그래서 ByteArrayOuputStream을 사용하면 이진데이터를 확인할 수 있다.
 */
public class DataOutputStreamEx2 {
	public static void main(String[] args) {
		ByteArrayOutputStream bos = null;
		DataOutputStream dos = null;
		
		byte[] result = null;
		
		try {
			bos = new ByteArrayOutputStream();
			dos = new DataOutputStream(bos);
			dos.writeInt(10);  //4byte
			dos.writeFloat(20.0f);  //4byte
			dos.writeBoolean(true);  //1byte
			
			result = bos.toByteArray();  //저장된 모든 내용이 바이트 배열로 반환
			
			String[] hex = new String[result.length];
			
			for(int i = 0; i < result.length; i++) {
				if(result[i] < 0) {
					//10진수 -> 16진수                          byte범위를 부호없는 것으로 변환 0~255   
					hex[i] = String.format("%02x",  result[i]+256);
				}else {
					hex[i] = String.format("%02x",  result[i]);
				}
			}
			System.out.println("10진수 : "+Arrays.toString(result)); //[0, 0, 0, 10, 65, -96, 0, 0, 1]
			System.out.println("16진수 : "+Arrays.toString(hex));  //[00, 00, 00, 0a, 41, a0, 00, 00, 01]
			
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
