package ch15;

import java.io.*;

public class DataInputStreamEx2 {
	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			
			while(true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			}
			//더이상 읽을 데이터가 없을때 exception발생
		} catch (EOFException e) {
			System.out.println("점수의 총합은 "+sum+" 입니다.");
		} catch(IOException ie){
			ie.printStackTrace();
		//작업도중 예외가 발생해서 스트림을 닫지 못하고 try블럭을 빠져나갈 수 있기 때문에 finally블럭을 이용해서 스트림을 닫아주는 것이 확실한 방법이다.
		}finally {
			try {
				//dis가 null일때 close()호출시 NullPointException이 발생하므로 null인지 먼저 체크후에 close()호출
				if(dis != null)
					dis.close();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
	}
}
