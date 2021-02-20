package ch14;

import java.util.Optional;
import java.util.OptionalInt;

/*	Optional<T> : T타입의 객체를 감싸는 래퍼 클래스이다.
 * 최종연산시 Optional객체에 담아서 반환시 반환된 결과가 null인지 체크할 필요없이 메서드를 이용해서 간단히 처리가능하다.
 * Optional 객체 생성시 of()-null을 담으면 에러 발생, ofNullable()-null을 담아도 에러X 사용
 * get()-값이 null일때 에러 발생, orElse("")-값이 null일때 ""반환
 * isPresent()-Optional객체의 값이 null이면 false를 아니면 true를 반환
 * ifPresent()-null이 아닐때만 실행
 */
public class OptionalEx1 {
	public static void main(String[] args) {
		Optional<String> optStr = Optional.of("abcde");
		Optional<Integer> optInt = optStr.map(String::length);
		System.out.println("optStr=" + optStr.get());
		System.out.println("optInt=" + optInt.get());

		int result1 = Optional.of("123").filter(x -> x.length() > 0).map(Integer::parseInt).get();
		int result2 = Optional.of("").filter(x -> x.length() > 0).map(Integer::parseInt).orElse(-1);
		System.out.println("result1=" + result1);
		System.out.println("result2=" + result2);

		Optional.of("456").map(Integer::parseInt).ifPresent(x -> System.out.printf("result3=%d%n", x));

		OptionalInt optInt1 = OptionalInt.of(0); // o저장
		OptionalInt optInt2 = OptionalInt.empty(); // 빈객체 생성

		System.out.println(optInt1.isPresent()); // true
		System.out.println(optInt2.isPresent()); // false

		System.out.println(optInt1.getAsInt()); // 0
		//System.out.println(optInt2.getAsInt());  NoSuchElementException
		System.out.println("optInt1=" + optInt1);
		System.out.println("optInt2=" + optInt2);
		System.out.println("optInt1.equals(optInt2)?" + optInt1.equals(optInt2));

		Optional<String> opt = Optional.ofNullable(null); // null저장
		Optional<String> opt2 = Optional.empty(); // null저장
		System.out.println("opt=" + opt);
		System.out.println("opt2=" + opt2);
		System.out.println("opt.equals(opt2)?" + opt.equals(opt2)); // true

		int result3 = optStrToInt(Optional.of("123"), 0);
		int result4 = optStrToInt(Optional.of(""), 0);

		System.out.println("result3=" + result3);
		System.out.println("result4=" + result4);
	}

	static int optStrToInt(Optional<String> optStr, int defalutValue) {
		try {
			return optStr.map(Integer::parseInt).get();
		} catch (Exception e) {
			return defalutValue;
		}

	}

}
