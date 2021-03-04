package ch15;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx2 {
	public static void main(String[] args) {
		//                번호   국어   영어   수학
		int[] score = {1, 100,   90,    90,
							2,   70,   90,  100,
							3, 100,  100,  100,
							4,   70,   50,    80,
							5,   70,   90,   100
				
		};
		
		try {
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
			for (int i = 0; i < score.length; i++) {
				raf.writeInt(score[i]); //파일포인터의 위치가 마지막으로 이동하기 때문에 readInt()를 호풀해도 데이터를 읽어오지 못하고 EOFException발생
			}
			
			raf.seek(0);  //파일포인터의 위치를 처음으로 이동시킨다음에 readInt()호출해야 데이터가 출력된다.
			while(true) {
				System.out.println(raf.readInt());
			}
		} catch (EOFException eof) {
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
