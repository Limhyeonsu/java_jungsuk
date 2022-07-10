package ch12;
/* 열거형에 추상메서드 추가
 * 열거형에 추상메서드를 선언하면 각 상수가 추상메서드를 반드시 구현해야한다.
 * */

enum Transportation{
	BUS(100) { int fare(int distance) {return distance*BASIC_FARE;}},
	TRAIN(150) { int fare(int distance) {return distance*BASIC_FARE;}},
	SHIP(100) { int fare(int distance) {return distance*BASIC_FARE;}},
	AIRPLANE(300) { int fare(int distance) {return distance*BASIC_FARE;}};
	
	protected final int BASIC_FARE;	//기본요금, protected로 해야 각 상수에서 접근 가능
	
	Transportation(int basicFare) {
		BASIC_FARE = basicFare;
	}
	
	
	public int getBasicFare() {return BASIC_FARE; }
	
	abstract int fare(int distance);	// 추상메서드  거리에 따른 요금계산
	
}

public class EnumEx3 {
	public static void main(String[] args) {
		System.out.println("bus fare ="+Transportation.BUS.fare(100));
		System.out.println("train fare ="+Transportation.TRAIN.fare(100));
		System.out.println("ship fare ="+Transportation.SHIP.fare(100));
		System.out.println("airplane fare ="+Transportation.AIRPLANE.fare(100));
		
		System.out.println(Transportation.BUS.getBasicFare());
		System.out.println(Transportation.TRAIN.getBasicFare());
		System.out.println(Transportation.SHIP.getBasicFare());
		System.out.println(Transportation.AIRPLANE.getBasicFare());
	}
}
