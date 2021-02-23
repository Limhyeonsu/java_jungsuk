package ch14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/* Collector 인터페이스구현하기
 * supplier() : 작업 결과를 저장할 공간 제공
 * accumulator() : 스트림의 요소를 수집할 방법 제공
 * combiner() : 두 저장공간을 병합할 방법을 제공(병렬 스트림)
 * finisher() : 결과를 최종적으로 변환할 방법을 제공
 * characteristics() : 컬렉터가 수행하는 작업의 속성에 대한 정보를 제공
 */
public class CollectorEx1 {
	public static void main(String[] args) {
		String[] strArr = {"aaa", "bbb", "ccc"};
		Stream<String> strStream = Stream.of(strArr);
		
		String result = strStream.collect(new ConcatCollector());
		
		System.out.println("strStream="+strStream);  //java.util.stream.ReferencePipeline$Head@681a9515
		System.out.println(Arrays.toString(strArr));
		System.out.println("result="+result);
		
	}
}

class ConcatCollector implements Collector<String, StringBuilder, String>{

	@Override
	public Supplier<StringBuilder> supplier() {
		return () -> new StringBuilder();
//		return StringBuilder::new;
	}

	@Override
	public BiConsumer<StringBuilder, String> accumulator() {
		return (sb, s) -> sb.append(s);
//		return StringBuilder::append;
	}

	@Override
	public BinaryOperator<StringBuilder> combiner() {
		return (sb, sb2) -> sb.append(sb2);
//		return StringBuilder::append;
	}

	@Override
	public Function<StringBuilder, String> finisher() {
		return sb -> sb.toString();
//		return StringBuilder::toString;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}
	
}