package ch12;

import java.util.ArrayList;

class Fruit2 implements Eatable{
	public String toString() { return "Fruit"; }
}

class Apple2 extends Fruit2{ public String toString() { return "Apple"; }}
class Grape2 extends Fruit2{ public String toString() { return "Grape"; }}
class Toy2 { public String toString() { return "Toy"; }}

interface Eatable{}

public class FruitBoxEx2 {

	public static void main(String[] args) {
		FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
		FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
		FruitBox2<Grape2> grapeBox = new FruitBox2<Grape2>();
		//FruitBox2<Grape2> grapeBox2 = new FruitBox2<Apple2>();  에러!! 타입 불일치
		//FruitBox2<Toy2> toyBox = new FruitBox2<Toy2>();  에러!!

		fruitBox.add(new Fruit2());
		fruitBox.add(new Apple2());
		fruitBox.add(new Grape2());
		appleBox.add(new Apple2());
		//appleBox.add(new Grape2());  에러!! Grape는 Apple의 자손이 아니다.
		grapeBox.add(new Grape2());
		
		System.out.println("fruitBox-"+fruitBox);
		System.out.println("appleBox-"+appleBox);
		System.out.println("grapeBox-"+grapeBox);
	}

}

//지네릭 타입에 'extends'를 사용하면 특정 타입의 자손들만 대입할 수 있게 제한할 수 있다.
//FruitBox2는 Fruit2의 자손이면서 Eatable을 구현한 클래스만 타입 매개변수 T에 대입될 수 있다.
class FruitBox2<T extends Fruit2 & Eatable> extends Box2<T>{};

class Box2<T>{
	ArrayList<T> list = new ArrayList<>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	int size() {return list.size();}
	public String toString() { return list.toString();}
}
