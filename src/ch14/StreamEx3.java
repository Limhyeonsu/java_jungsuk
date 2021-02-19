package ch14;

import java.util.*;
import java.util.stream.*;

/* map()은 연산의 결과로 Stream<T> 타입을 반환한다.
 * 숫자로 반환하는 경우 기본형 스트림으로 변환하는 것이 더 유용하다.
 * mapToInt(), mapToLong(), mapToDouble()을 사용하면 기본형 스트림을 결과로 반환한다.
 * 기본형 스트림은 sum(), average(), max(), min()과 같은 메서드 제공(최종연산으로 연속해서 호출불가)
 * IntSummaryStatistics()를 통해서 스트림을 재생성하지 않고도 위의 메서드 사용가능
 */
public class StreamEx3 {
	public static void main(String[] args) {
		Student2[] stuArr = {
				new Student2("이자바",  3,  300),
				new Student2("김자바",  1,  200),
				new Student2("안자바",  2,  100),
				new Student2("박자바",  2,  150),
				new Student2("소자바",  1,  200),
				new Student2("나자바",  3,  290),
				new Student2("감자바",  3,  180)
		};
		
		Stream<Student2> stuStream = Stream.of(stuArr);
		
		stuStream.sorted(Comparator.comparing(Student2::getBan)	//반별로 정렬
				.thenComparing(Comparator.naturalOrder()))	//기본정렬
				.forEach(System.out::println);
		
		//스트림 재생성
		stuStream = Stream.of(stuArr);
		IntStream stuScoreStream = stuStream.mapToInt(Student2::getTotalScore);
		
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		System.out.println("count = "+stat.getCount());
		System.out.println("sum = "+stat.getSum());
		System.out.printf("average = %.2f%n", stat.getAverage());
		System.out.println("min = "+stat.getMin());
		System.out.println("max = "+stat.getMax());
	}
}

class Student2 implements Comparable<Student2>{
	String name;
	int ban;
	int totalScore;
	
	Student2(String name, int ban, int totalScore){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]",  name, ban, totalScore).toString();
	}
	
	String getName() { return name; }
	int getBan() { return ban; }
	int getTotalScore() { return totalScore; }
	
	public int compareTo(Student2 s) {
		return s.totalScore - this.totalScore;
	}
}