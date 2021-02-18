package ch14;

import java.util.function.Function;
import java.util.function.Predicate;

/*	Function의 합성
 * 두 람다식을 합성해서 새로운 람다식을 만들 수 있다. 어느 함수를 먼저 적용하느냐에 따라 결과가 달라진다.
 * ex) f.andThen(g) 함수 f를 먼저 적용하고, 그 뒤에 함수 g적용
 * 	     f.compose(g)는 반대로 g를 먼저 적용하고, f를 적용
 * 
 * Predicate의 결합
 * and(), or(), negate()
 */
public class LamdaEx7 {
	public static void main(String[] args) {

		Function<String, Integer> f = (s)-> Integer.parseInt(s, 16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
		
		Function<String, String> h = f.andThen(g);		// f 먼저 적용 후 g적용
		Function<Integer, Integer> h2 = f.compose(g);	// g 먼저 적용 후 f적용
		
		System.out.println(h.apply("FF"));	// "FF" -> 1) 255 -> 2) "11111111"
		System.out.println(h2.apply(2));	//	2 -> 1) "10" -> 2) "16"
		
		Function<String, String> f2 = x -> x;		//이전과 이후가 동일한 '항등함수'
		System.out.println(f2.apply("AAA"));	// 동일한 결과를 출력하기 때문에 "AAA"가 출력됨
		
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 == 0;
		Predicate<Integer> notP = p.negate();	// i >= 100
		
		Predicate<Integer> all = notP.and(q.or(r));		//i >= 100 && (i <200 || i%2 ==0)
		System.out.println(all.test(150));		//true
		
		String str1 = "abc";
		String str2 = "abc";
		
		//str1과 str2가 같은지 비교
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result);
		
	}
}
