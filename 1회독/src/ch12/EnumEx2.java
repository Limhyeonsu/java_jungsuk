package ch12;
/* 열거형에 멤버추가
 * 열거형 상수의 값이 불연속적인 경웅는 열거형 상수의 이름 옆에 원하는 값을 괄호와 함께 적어준다
 * 지정된 값을 저장할 수 있는 인스턴스 변수와 생성자를 새로 추가한다
 * 열거형의 생성자는 묵시적으로 private이기 때문에 외부에서 호출할 수 없다.
 * */
enum Direcion2{
	EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");
	
	private static final Direcion2[] DIR_ARR = Direcion2.values();
	private final int value;
	private final String symbol;
	
	Direcion2(int value, String symbol){
		this.value = value;
		this.symbol = symbol;
	}
	public int getValue() { return value; }
	public String getSymbol() { return symbol; }
	
	public static Direcion2 of(int dir) {
		if(dir < 1 || dir > 4) {
			throw new IllegalArgumentException("Invalid value : "+dir);
		}
		return DIR_ARR[dir - 1];
	}
	
	//방향을 회전시키는 메서드 num의 값만큼 90도씩 시계방향
	public Direcion2 rotate(int num) {
		num = num % 4;
		
		if(num < 0) num += 4;
		
		return DIR_ARR[(value-1+num)%4];
	}
	
	public String toString() {
		return name()+getSymbol();
	}
}

public class EnumEx2 {
	public static void main(String[] args) {
		for(Direcion2 d : Direcion2.values())
			System.out.printf("%s=%d%n", d.name(), d.getValue());
		
		Direcion2 d1 = Direcion2.EAST;
		Direcion2 d2 = Direcion2.of(1);
		
		System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
		System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
		
		System.out.println(Direcion2.EAST.rotate(1));
		System.out.println(Direcion2.EAST.rotate(2));
		System.out.println(Direcion2.EAST.rotate(-1));
		System.out.println(Direcion2.EAST.rotate(-2));
	}

}
