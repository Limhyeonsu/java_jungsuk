package ch15;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamEx1 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("sample.dat");
			DataInputStream dis = new DataInputStream(fis);
			//여러가지 종류의 자료형으로 출력한 경우 반드시 쓰인 순서대로 읽어와야한다.
			//DataOutputStreamEx1에서 writeInt(), writeFloat(), writeBoolean() 
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readBoolean());
			dis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
