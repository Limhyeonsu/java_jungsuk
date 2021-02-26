package ch15;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOuputStreamEx3 {
	public static void main(String[] args) {
		int[] score = { 100, 90, 95, 85, 50 };
		
		try {
			FileOutputStream fos = new FileOutputStream("score.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			
			for (int i = 0; i < score.length; i++) {
				// int의 크기가 4byte이므로 총 20byte의 데이터가 저장됨
				dos.writeInt(score[i]);
			}
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
