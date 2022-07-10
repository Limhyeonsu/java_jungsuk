package ch15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx1 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			//버퍼를 이용한 FileOutputStream 기반스트림 생성
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
			UserInfo u2 = new UserInfo("JavaWoman", "4321", 26);
			
			ArrayList<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			
			//객체를 직렬화 한다.
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);  //ArrayList에 저장된 모든 객체들과 각 객체의 인스턴스변수가 참조하고 있는 객체들까지 모두 직렬화 됨.
			out.close();
			System.out.println("직렬화가 잘 끝났습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
