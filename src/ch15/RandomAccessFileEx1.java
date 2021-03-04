package ch15;

import java.io.RandomAccessFile;

/* RandomAccessFile : 하나의 클래스로 파일에 대한 입력과 출력을 모두 할 수 있도록 되어 있다.
 * DataInput, DataOutput인터페이스를 모두 구현했기 때문에 읽기와 쓰기가 모두 가능하다.
 * 또한 기본자료형 단위로 데이터를 읽고 쓸 수 있고, 파일에 읽고 쓰는 위치에 제한이 없다(내부적으로 파일 포인터 사용)
 */
public class RandomAccessFileEx1 {
	public static void main(String[] args) {
		try {
			//"r" - 파일로부터 읽기 / "rw" - 파일에 읽기와 쓰기
			RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
			System.out.println("파일 포인터의 위치 : "+raf.getFilePointer()); //0
			raf.writeInt(100); //4byte
			System.out.println("파일 포인터의 위치 : "+raf.getFilePointer()); //4
			raf.writeLong(100L); //8byte
			System.out.println("파일 포인터의 위치 : "+raf.getFilePointer()); //12
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
