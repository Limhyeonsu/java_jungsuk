package ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//컬렉션 프레임워크와 함수형 인터페이스 예제
public class LamdaEx4 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++)
			list.add(i);
		
		//forEach : 모든요소의 작업 수행
		list.forEach(i->System.out.print(i+","));
		System.out.println();	//0,1,2,3,4,5,6,7,8,9
		
		//removeIf : 조건에 맞는 요소를 삭제, list에서 2 또는 3의 배수를 제거한다.
		list.removeIf(x-> x%2==0 || x%3==0);
		System.out.println(list);	//1, 5, 7
		
		//replaceAll : 모든 요소를 변환하여 대체, list의 각 요소에 10을 곱한다.
		list.replaceAll(i->i*10);
		System.out.println(list);	//10, 50, 70
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		map.forEach((k,v)->System.out.print("{"+k+", "+v+"},"));
		//{1, 1},{2, 2},{3, 3},{4, 4}
		System.out.println();
	}

}
