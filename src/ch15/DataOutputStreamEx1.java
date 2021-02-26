package ch15;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/* DataInputStream, DataOutputStream
 * 데이터를 읽고 쓰는데 byte단위가 아닌, 8가지 기본 자료형의 단위로 읽고 쓸 수 있다.
 * 각 기본 자료형 값을 16진수로 표현
 * 각 자료형의 크기가 다르므로 출력한 데이터를 다시 읽어 올 때는 출력했을때의 순서를 염두해야한다. 
 */
public class DataOutputStreamEx1 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			//sample.dat 파일을 생성해서 출력값을 집어넣어준다.
			//이진 데이터로 저장되기 때문에 알 수 없는 글자들로 보임
			fos = new FileOutputStream("sample.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
			
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
