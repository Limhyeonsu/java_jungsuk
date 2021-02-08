package ch12;
/* 열거형 : 실제 값이 같아도 타입이 다르면 조건식의 결과가 false가 된다. =>타입까지 검사하기 때문에 타입에 안전하다
 * 비교에는 '==' 사용, 비교연산자는 사용할 수 없고 compareTo() 사용가능하다 
 * enum 열거형이름 {상수1, 상수2, ...}
 * */
enum Direction {EAST, SOUTH, WEST, NORTH};

public class EnumEx1 {
	public static void main(String[] args) {
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		//valueOf() : 지정된 열거형에서 name과 일치하는 열거형 상수를 반환
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1 = "+d1);
		System.out.println("d2 = "+d2);
		System.out.println("d3 = "+d3);

		System.out.println("d1 == d2 ? "+(d1==d2));
		System.out.println("d1 == d3 ? "+(d1==d3));
		System.out.println("d1.equals(d3) ? "+d1.equals(d3));
		//System.out.println("d2 > d3 ? "+(d2 > d3));  에러!!
		System.out.println("d1.compareTo(d3) ? "+(d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2) ? "+(d1.compareTo(d2)));
		
		switch (d1) {
			case EAST :
				System.out.println("The direction is EAST."); break;
			case SOUTH :
				System.out.println("The direction is SOUTH."); break;
			case WEST :
				System.out.println("The direction is WEST."); break;
			case NORTH :
				System.out.println("The direction is NORTH."); break;
			default :
				System.out.println("Invalid direction."); break;
		}
		// values() : 열거형의 모든 상수를 배열에 담아 반환한다.
		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr)
			System.out.printf("%s=%d%n", d.name(), d.ordinal());
		// ordinal : 상수가 정의된 순서 반환, 이 값은 내부적인 용도로만 사용!
		// EAST=0, SOUTH=1, WEST=2, NORTH=3
	}

}
