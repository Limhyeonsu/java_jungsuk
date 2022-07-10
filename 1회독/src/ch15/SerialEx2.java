package ch15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx2 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			ObjectInputStream in = new ObjectInputStream(bis);
			
			//객체를 읽을 때는 출력한 순서와 일치해야한다.
			//readObject()의 리턴타입이 Object이기 때문에 원래의 타입으로 형변환 필요!
			UserInfo u1 = (UserInfo)in.readObject();
			UserInfo u2 = (UserInfo)in.readObject();
			ArrayList list = (ArrayList)in.readObject();
			
			System.out.println(u1);  // (JavaMan, 1234, 30)
			System.out.println(u2);  // (JavaWoman, 4321, 26)
			System.out.println(list); //  [(JavaMan, 1234, 30), (JavaWoman, 4321, 26)]
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
