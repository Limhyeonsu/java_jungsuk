package ch14;

import java.util.*;
import java.util.stream.Collectors.*;
import java.util.stream.*;

/* collect() : 스트림의 요소를 수집하는 최종연산, 매개변수로 Collector타입이 필요함.
 * Collector : 인터페이스, 컬렉터는 이 인터페이스를 구현하여야 한다.
 * Collectors : 미리 작성된 다양한 종류의 컬렉터를 반환하는 static 메서드를 가지고 있다.
 * 스트림의 묘든 요소를 컬렉션에 수집하려면 Collectors클래스의 toList(), toSet(), toMap(), toCollection(), toArray() 사용
 * 통계정보 - counting(), summingInt(), averagingInt(), maxBy(), minBy()
 * reducing()
 */
public class StreamEx6 {
	public static void main(String[] args) {
		Student[] stuArr = {
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 180),
		};
		
		//학생 이름만 뽑아서 List에 저장
		List<String> names = Stream.of(stuArr).map(Student::getName).collect(Collectors.toList());	//stream을 list로 변환
		System.out.println(names);
		
		//스트림을 배열로 변환
		Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);
		
		for(Student s : stuArr2)
			System.out.println(s);
		
		//스트림을 Map<String, Student>로 변환, 학생이름이 key
		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s->s.getName(), p->p));
		
		for(String name : stuMap.keySet())
			System.out.println(name + "-"+stuMap.get(name));
		
		long count = Stream.of(stuArr).collect(Collectors.counting());
		long totalScore = Stream.of(stuArr).collect(Collectors.summingInt(Student::getTotalScore));
		System.out.println("count="+count);
		System.out.println("totalScore="+totalScore);
		
		totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		System.out.println("totalScore="+totalScore);
		
		Optional<Student> topStudent = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparing(Student::getTotalScore)));
		System.out.println("topStudent="+topStudent.get());
		
		IntSummaryStatistics stat = Stream.of(stuArr).collect(Collectors.summarizingInt(Student::getTotalScore));
		System.out.println(stat);	//IntSummaryStatistics{count=7, sum=1420, min=100, average=202.857143, max=300}
		
		String stuNames = Stream.of(stuArr).map(Student::getName).collect(Collectors.joining(",", "{", "}"));
		System.out.println(stuNames);
	}
}

class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	
	Student(String name, int ban, int totalScore){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
	}
	
	String getName() {	return name; }
	int getBan() { return ban; }
	int getTotalScore() { return totalScore; }
	
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}