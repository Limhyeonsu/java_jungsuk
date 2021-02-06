package ch11;

import java.util.Enumeration;
import java.util.Properties;

/* Properties는 HashMap의 구버전인 Hashtable을 상속받아 구현,
 * Hashtable(Object, Object) -> Properties(String, String)
 * 간단한 입출력은 Properties를 활용하면 간단하게 해결
 * */
public class PropertiesEx1 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("timeout",  "30");
		prop.setProperty("language",  "kr");
		prop.setProperty("size",  "10");
		prop.setProperty("capacity",  "10");
		
		//prop에 저장된 요소들을 출력한다, propertyNames():key를 set에 담아서 반환함
		//Properties는 컬렉션의 구버전으로 Iterator가 아닌 Enumeration을 사용한다.
		Enumeration e = prop.propertyNames();
		
		//저장순서를 유지하지 않는다
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();
			System.out.println(element + "="+prop.getProperty(element));
		}
		
		System.out.println();
		//기존의 중복된 키가 있으면 값을 덮어 씌운다.
		prop.setProperty("size",  "20");
		System.out.println("size = "+prop.getProperty("size"));
		//getProperty()는 저장된 값을 읽어오는데 읽어오려는 키가 존재하지 않으면 지정된 기본값을 반환한다.
		System.out.println("capacity = "+prop.getProperty("capacity", "20"));
		System.out.println("loadfactor = "+prop.getProperty("loadfactor", "0.75"));
		
		System.out.println(prop);
		prop.list(System.out);
	}

}
