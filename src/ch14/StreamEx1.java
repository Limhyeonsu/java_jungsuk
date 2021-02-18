package ch14;

import java.util.Comparator;
import java.util.stream.Stream;

/* 많은 수의 데이터를 다룰 때 데이터 소스마다 같은 기능의 메서드들이 중복정의 되어 있어 다른 방식으로 사용해야하는 불편함이 있다
 * Stream은 데이터 소스를 추상화(데이터 소스를 같은 방식으로 다룰 수 있게)하였다. -> 코드의 재사용성을 높임
 * 1) 스트림은 데이터 소스로부터 데이터를 읽기만할 뿐, 데이터 소스를 변경하지 않는다
 * 2) 스트림은 Iterator처럼 일회용이다. 한 번 사용하고 재사용 하려면 다시 스트림을 생성해야한다.
 * 3) 스트림은 작업을 내부 반복으로 처리한다.
 * 4) 스트림의 연산 : 중간연산(연산 결과가 스트림, 연속해서 연산 가능), 최종연산(연산 결과가 스트림이 아닌 연산, 단 한번만 가능)
 * 		최종 연산이 수행되기 전까지는 중간 연산이 수행되지 않는다. 중간연산을 호출해도 즉각적으로 수행되는것이 아니다.
 * 5) 병렬처리가 쉬움, parallel() : 병렬로 연산 수행 / sequential() : 병렬 연산 취소
 */
public class StreamEx1 {
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
								new Student("이자바",  3,  300),
								new Student("김자바",  1,  200),
								new Student("안자바",  2,  100),
								new Student("박자바",  2,  150),
								new Student("소자바",  1,  200),
								new Student("나자바",  3,  290),
								new Student("감자바",  3,  180)
				);
		
		studentStream.sorted(Comparator.comparing(Student::getBan)	//반별정렬
				.thenComparing(Comparator.naturalOrder()))	//정렬조건 추가 :기본정렬
				.forEach(System.out::println);
				
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
		return String.format("[%s, %d, %d]",  name, ban, totalScore);
	}
	
	String getName() { return name; }
	int getBan() { return ban; }
	int getTotalScore() { return totalScore; }
	
	//총점별 내림차순 정렬을 기본정렬로 설정
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}