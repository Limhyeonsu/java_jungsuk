package ch15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* 바이트 기반 보조스트림
 * 스트림의 기능을 보완하기 위해 보조스트림이 제공된다. 보조스트림만으로는 입출력을 처리할 수 없고,
 * 보조스트림의 기반이 되는 스트림을 먼저 생성 후 이를 이용할 보조스트림을 생성해야한다.
 * FilterInputStream, FilterOutputStream은 모든 보조스트림의 조상이다.
 * FilterStream자체는 아무 일도 하지 않으므로 상속을 통해 원하는 작업을 수행하도록 읽고 쓰는 메서드를 오버라이딩해야한다.
 * BufferedInputStream, BufferedOutputStream은 입출력의 효율을 높이기 위해 사용된다.
 * input 버퍼의 크기만큼 데이터를 읽어서 내부에 저장한다. ouput 버퍼가 가득파면 그때 버퍼의 모든 내용을 출력소스에 출력
 * 버퍼가 가득 찼을때만 출력소스에 출력을 하기 때문에 버퍼에 남아있는채로 프로그램이 종료될 수 있다. 그래서  close(), flush()를 통해 모든 내용이 출력되게 해야한다.
 *  */
public class BufferedOutputStreamEx1 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			//버퍼크기를 5로 생성한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			for(int i ='1'; i <= '9'; i++) {
				bos.write(i);
			}
			fos.close();  //12345출력
//			bos.flush();  123456789 출력
//			bos.close();  123456789 출력
			//bos.close()를 하면 자동으로 fos.flush()가 호출됨(보조스트림을 닫으면 기반도 자동으로 닫힌다. 그러니 보조스트림을 닫자!)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
