package ch14;
/*	그룹화 : 스트림의 요소를 특정 기준으로 그룹화 / 분할 : 스트림의 요소를 두가지, 조건에 일치하는 그룹, 일치하지 않는 그룹으로 분할
 * groupingBy() : 스트림의 요소를 Function으로 / partitioningBy() : 스트림의 요소를 Predicate로 분류한다.
 * 스트림을 두 개의 그룹으로 나눠야 한다면 partitioningBy()로 분할하는 것이 빠르다, 그외엔 groupingBy()사용
 * 그룹화와 분할의 결과는 Map에 담겨서 반환된다.
 */

import java.util.*;
import java.util.stream.Collectors.*;
import java.util.stream.*;

class Student3 {
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	Student3(String name, boolean isMale, int hak, int ban, int score){
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}
	String getName() { return name; }
	boolean isMale() { return isMale; }
	int getHak() { return hak; }
	int getBan() { return ban; }
	int getScore() { return score; }
	
	public String toString() {
		return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남":"여", hak, ban, score);
	}
	// groupingBy() 에서 사용, 성적을 상, 중, 하로 분류
	enum Level { HIGH, MID, LOW }
}

public class StreamEx7 {
	public static void main(String[] args) {
		Student3[] stuArr = {
				new Student3("나자바", true, 1, 1, 300),
				new Student3("김지미", false, 1, 1, 250),
				new Student3("김자바", true, 1, 1, 200),
				new Student3("이지미", false, 1, 2, 150),
				new Student3("남자바", true, 1, 2, 100),
				new Student3("안지미", false, 1, 2, 50),
				new Student3("황지미", false, 1, 3, 100),
				new Student3("강지미", false, 1, 3, 150),
				new Student3("이자바", true, 1, 3, 200),
				
				new Student3("나자바", true, 2, 1, 300),
				new Student3("김지미", false, 2, 1, 250),
				new Student3("김자바", true, 2, 1, 200),
				new Student3("이지미", false, 2, 2, 150),
				new Student3("남자바", true, 2, 2, 100),
				new Student3("안지미", false, 2, 2, 50),
				new Student3("황지미", false, 2, 3, 100),
				new Student3("강지미", false, 2, 3, 150),
				new Student3("이자바", true, 2, 3, 200)
		};
		
		System.out.printf("1. 단순분할(성별로 분할)%n");
		Map<Boolean, List<Student3>> stuBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student3::isMale));
		
		List<Student3> maleStudent = stuBySex.get(true);
		List<Student3> femaleStudent = stuBySex.get(false);
		
		for(Student3 s :maleStudent) System.out.println(s);
		for(Student3 s :femaleStudent) System.out.println(s);
		
		System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student3::isMale, Collectors.counting()));
		System.out.println("남학생 수 : "+stuNumBySex.get(true));
		System.out.println("여학생 수 : "+stuNumBySex.get(false));
		
		System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
		Map<Boolean ,Optional<Student3>> topScoreBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student3::isMale, Collectors.maxBy(Comparator.comparingInt(Student3::getScore))
						));
		System.out.println("남학생 1등 : "+topScoreBySex.get(true));
		System.out.println("여학생 1등 : "+topScoreBySex.get(false));
		
		Map<Boolean, Student3> topScoreBySex2 = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student3::isMale, Collectors.collectingAndThen(Collectors.maxBy
						(Comparator.comparingInt(Student3::getScore)), Optional::get)
						));
		System.out.println("남학생 1등 : "+topScoreBySex2.get(true));
		System.out.println("여학생 1등 : "+topScoreBySex2.get(false));
		
		System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");
		Map<Boolean, Map<Boolean, List<Student3>>> failedStuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student3::isMale,
				Collectors.partitioningBy(s->s.getScore() <= 100)
				));
		List<Student3> failedMaleStu = failedStuBySex.get(true).get(true);
		List<Student3> failedFemaleStu = failedStuBySex.get(false).get(true);
		
		for(Student3 s : failedMaleStu) System.out.println(s);
		for(Student3 s : failedFemaleStu) System.out.println(s);
	}
}
