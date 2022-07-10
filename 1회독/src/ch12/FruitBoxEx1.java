package ch12;
/* 지네릭스란 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일시 타입 체크를 해주는 기능
 * 타입의 안정성을 높여주고 형변환의 번거로움을 줄여준다.
 * */

import java.util.ArrayList;

class Fruit {public String toString() {return "Fruit";}}
class Apple extends Fruit {public String toString() {return "Apple";}}
class Grape extends Fruit   {public String toString() {return "Grape";}}
class Toy {public String toString() {return "Toy";}}

public class FruitBoxEx1 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
		//Box<Grape> grapeBox = new Box<Apple>();  에러!! 참조변수와 생성사에 대입된 타입은 일치해야한다
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		//fruitBox.add(new Toy());   에러!! fruitBox에는 Fruit와 자손들만 담을 수 있다
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		//appleBox.add(new Grape());  에러!! appleBox에는 Apple타입만 담을 수 있다
		//appleBox.add(new Toy());  에러!! appleBox에는 Apple타입만 담을 수 있다
		
		toyBox.add(new Toy());
		//toyBox.add(new Apple());  에러!! toyBox에는 Toy타입만 담을 수 있다
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}
}

class Box<T>{
	ArrayList<T> list = new ArrayList<>();
	void add(T item) { list.add(item); }
	T get(int i) {return list.get(i); }
	int size() {return list.size(); }
	public String toString() { return list.toString(); }
}