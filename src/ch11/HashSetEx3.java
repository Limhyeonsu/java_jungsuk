package ch11;

import java.util.HashSet;

public class HashSetEx3 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		//"abc"는 중복값 X, Person객체는 값이 같음에도 서로 다른 것으로 인식함.
		set.add("abc");
		set.add("abc");
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));
		
		System.out.println(set);
	}
}

class Person{
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name +":"+age;
	}
}