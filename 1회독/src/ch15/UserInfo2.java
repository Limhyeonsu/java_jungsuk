package ch15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//직렬화되지 않은 조상으로부터 상속받은 인스턴스변수에 대하여 직렬화를 구현한 예제
class SuperUserInfo{
	String name;
	String password;
	
	SuperUserInfo(){
		this("Unknown", "1111");
	}
	
	SuperUserInfo(String name, String password){
		this.name = name;
		this.password = password;
	}
}

public class UserInfo2 extends SuperUserInfo implements java.io.Serializable{

	int age;
	
	public UserInfo2() {
		this("Unknown", "1111", 0);
	}
	
	public UserInfo2(String name, String password, int age) {
		super(name, password);
		this.age = age;
	}
	
	public String toString() {
		return "("+name+", "+password+", "+age+")";
	}
	
	//직접 직렬화 되도록 구현.
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeUTF(name);
		out.writeUTF(password);
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		name = in.readUTF();
		password = in.readUTF();
		in.defaultReadObject();
	}

}
