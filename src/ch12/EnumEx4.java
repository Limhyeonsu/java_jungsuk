package ch12;


abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T>{
	static int id = 0;
	int ordinal;
	String name = "";
	
	public int ordinal() {return ordinal;}
	
	MyEnum(String name){
		this.name = name;
		ordinal = id++;		//객체가 생성될 때마다 id의 값을 증가시킨다
	}
	
	public int compareTo(T t) {
		return ordinal - t.ordinal();
	}
}

abstract class MyTransportation extends MyEnum{
	//익명클래스의 형태로 추상메서드 구현
	static final MyTransportation BUS = new MyTransportation("BUS", 100) {
		int fare(int distance) { return distance * BASIC_FARE; }
	};
	static final MyTransportation TRAIN = new MyTransportation("TRAIN", 150) {
		int fare(int distance) { return distance * BASIC_FARE; }
	};
	static final MyTransportation SHIP = new MyTransportation("SHIP", 100) {
		int fare(int distance) { return distance * BASIC_FARE; }
	};
	static final MyTransportation AIRPLANE = new MyTransportation("AIRPLANE", 300) {
		int fare(int distance) { return distance * BASIC_FARE; }
	};
	
	abstract int fare(int distance);		//추상메서드
	
	protected final int BASIC_FARE;
	
	private MyTransportation(String name, int basicFare) {
		super(name);
		BASIC_FARE = basicFare;
	}
	
	public String Name() {return name; }
	public String toString() {return name; }
	
}
public class EnumEx4 {
	public static void main(String[] args) {
		MyTransportation t1 = MyTransportation.BUS;
		MyTransportation t2 = MyTransportation.BUS;
		MyTransportation t3 = MyTransportation.TRAIN;
		MyTransportation t4 = MyTransportation.SHIP;
		MyTransportation t5 = MyTransportation.AIRPLANE;
		
		System.out.printf("t1=%s, %d%n", t1.Name(), t1.ordinal());
		System.out.printf("t2=%s, %d%n", t2.Name(), t2.ordinal());
		System.out.printf("t3=%s, %d%n", t3.Name(), t3.ordinal());
		System.out.printf("t4=%s, %d%n", t4.Name(), t4.ordinal());
		System.out.printf("t5=%s, %d%n", t5.Name(), t5.ordinal());
		
		System.out.println("t1 == t2 ? "+(t1 == t2));
		System.out.println("t1.compareTo(t3)="+t1.compareTo(t3));
		// TODO Auto-generated method stub

	}

}
