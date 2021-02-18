package ch14;

import java.io.File;
import java.util.stream.Stream;

/* map() : 중간연산, 스트림 요소에 저장된 값 중 원하는 값만 뽑거나 특정 형태로 변환해야 할 때 사용
 * peek() : 연산과 연산사이에 올바르게 처리되었는지 확인 filter()나 map()의 결과를 확인할때 유용하게 사용
 */
public class StreamEx2 {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"),
				new File("Ex1"), new File("Ex1.txt")
		};
		
		Stream<File> fileStream =Stream.of(fileArr);	//스트림생성
		
		// map()을 이용하여 Stream<File> -> Stream<String>으로 변환
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);		//모든 파일 이름 출력
		
		fileStream = Stream.of(fileArr);		//스트림 재생성
		
		fileStream.map(File::getName)		//Stream<File> -> Stream<String>
		.filter(s -> s.indexOf('.') != -1)		//확장자가 없는 것은 제외
		.map(s -> s.substring(s.indexOf('.')+1))	//확장자만 추출
		.map(String::toUpperCase)	//대문자로 변환
		.distinct()	//중복제거
		.forEach(System.out::print);
		
		System.out.println();
		
	}

}
