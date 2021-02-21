package ch14;

import java.util.*;
import java.util.stream.*;

/*	스트림의 최종연산
 * 조건검사 - allMatch(), anyMatch(), noneMatch(), findFirst(), findAny()
 * 통계 - count(), sum(), average(), max(), min()
 * forEach() : 스트림의 요소를 출력하는 용도
 * reduce() : 스트림의 요소를 줄여나가면서 연산을 수행, 최종결과를 반환한다. 초기값과 어떤 연산인지만 결정하면 된다.
 */
public class StreamEx5 {
	public static void main(String[] args) {
		String[] strArr = {
				"Inheritance", "Java", "Lambda", "stream",
				"OptionalDouble", "IntStream", "count", "sum"
		};
		Stream.of(strArr).forEach(System.out::println);
		//noneMatch() : 모든 요소가 주어진 조건을 만족하지 않는지
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);		//true
		Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst();	//stream
		System.out.println("noEmptyStr="+noEmptyStr);
		System.out.println("sWord="+sWord.get());
		
		//Stream<String[]>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		
		int count = intStream1.reduce(0, (a,b)-> a+1);
		int sum = intStream2.reduce(0,  (a,b) -> a+b);
		
		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);
		
		System.out.println("count="+count);
		System.out.println("sum="+sum);
		System.out.println("max="+max);						//max=OptionalInt[14]
		System.out.println("max="+max.getAsInt());		//max=14
		System.out.println("min="+min);						//min=OptionalInt[3]
		System.out.println("min="+min.getAsInt());   	//min=3
		
	}
}
