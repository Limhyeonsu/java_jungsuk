package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* 입출력 수행시 데이터를 전달하려면 두 대상을 연결하고 데이터를 전송할 수 있는 스트림(Stream)이 필요
 * Stream : 데이터를 운반하는데 사용되는 연결통로, 단방향 통신만 가능하기 때문에 하나의 스트림으로 입출력을 동시에 수행할 수 없다.
 * 입력스트림(input stream), 출력스트림(output stream)필요
 * 
 * [바이트기반스트림]
 * 스트림은 바이트단위로 데이터를 전송한다.
 * 스트림의 종류에 따라서 mark()-현재위치를 표시 / reset()-스트림에서의 위치를 마지막 mark() 호출되었던 위치로 되돌린다.
 * 를 사용하여 이미 읽은 데이터를 되돌려서 다시 읽을 수 있다.
 * flush() : 스트림의 버퍼에 이쓴 모든 내용을 출력, 버퍼가 있는 출력스트림의 경우에 의미있음
 * close() : 모든 작업을 마치고 난 뒤에는 스트림을 닫아주어야한다.
 * ByteArrayInputStream, ByteArrayOutputStream : 다른 곳에 입출력하기 전에 데이터를 임시로 바이트배열에 담아서 변환작업을 하는데 사용
 */
public class IOEx1 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		//기반스트림
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		//read() : 1byte를 읽어온다 더이상 읽어올 데이터가 없으면 -1 반환
		while((data = input.read()) != -1) {
			System.out.print(data); //0123456789
			output.write(data);	//주어진 값을 출력소스에 사용
		}
		System.out.println(output);	//ㅁㅁㅁㅁㅁ
		
		outSrc = output.toByteArray();  //스트림의 내용을 byte 배열로 반환
		
		System.out.println("Input Source : "+Arrays.toString(inSrc));
		System.out.println("Output Source : "+Arrays.toString(outSrc));
		
		/* 바이트 배열은 사용하는 자원이 메모리 밖에 없으므로 가비지 컬렉터에 의해 자동적으로 자원을 반환
		 * 그러므로 close()를 이용해서 스트림을 닫지 않아도 된다
		 * 한 번에 1byte만 읽고 쓰므로 작업 효율이 떨어진다.
		 */
		}
}
