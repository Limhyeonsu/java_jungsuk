package ch15;
/* 직렬화 : 객체를 데이터 스트림으로 만드는 것을 뜻한다.  ObjectOutputStream의 writeObject() 사용
 * (객체에 저장된 데이터를 스트림에 쓰기(write) 위해 연속적인 데이터로 변환하는 것)
 * 역직렬화 : 스트림으로부터 데이터를 읽어서 객체를 만드는 것.  ObjectInputStream의 readObject() 사용(객체의 원래타입으로 형변환 필요)
 * ObjectInputStream, ObjectOutputStream은 보조스트림으로 객체를 생성할때 기반스트림을 지정해주어야 한다.
 * 직렬화가 가능한 클래스를 만들고자 할때 java.io.Serializable 인터페이스를 구현하도록 한다.
 * 아무 내용이 없는 빈 인터페이스이지만 직렬화를 고려한 클래스인지 판단하는 기준이 된다.
 * new Object()는 최고 조상으로 Serializable을 구현하지 않았기 때문에 직렬화할 수 없다.\
 * 제어자 transient를 붙이면 직렬화 대상에서 제외할 수 있다.
 */
public class UserInfo implements java.io.Serializable {
	String name;
	String password;
	int age;
	
	public UserInfo() {
		this("Unknown", "1111", 0);
	}

	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public String toString() {
		return "("+name+", "+password+", "+age+")";
	}
}
