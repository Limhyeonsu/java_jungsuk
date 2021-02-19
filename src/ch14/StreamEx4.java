package ch14;

import java.util.*;
import java.util.stream.*;

/*	flatMap() : Stream<T[]> -> Stream<T>
 * map() 은 Stream<Stream<T>>의 결과가 나타난다
 */
public class StreamEx4 {
	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(
				new String[] {"abc", "def", "jkl"},
				new String[] {"ABC", "GHI", "JKL"}
		);
		
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
		//소문자로 변경, 중복제거, 정렬
		strStrm.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		String[] lineArr = {
				"Believe or not It is true",
				"Do or do not There is no try",
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +")))
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");
		
		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
		//toArray() : 스트림을 배열로 변환해서 반환, 매개변수 미지정시 Object[]을 반환하므로 특정타입을 지정해주어야함
		Stream<String> strStream = strStrmStrm.map(s -> s.toArray(String[]::new))
					.flatMap(Arrays::stream);		//Stream<String[]> -> Stream<String>으로 변환
		
		strStream.map(String::toLowerCase)
		.distinct()
		.forEach(System.out::println);
	}
}
