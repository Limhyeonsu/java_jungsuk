package ch11;

import java.util.Properties;

public class PropertiesEx4 {

	public static void main(String[] args) {
		//시스템과 관련된 속성이 저장된 Properties를 가져올 수 있다.
		Properties sysProp = System.getProperties();
		//원하는 속성을 getProperty()를 통해서 읽어올 수 있다.
		System.out.println("java.version :"+sysProp.getProperty("java.version"));
		System.out.println("user.language :"+sysProp.getProperty("user.language"));
		sysProp.list(System.out);

	}

}
