package ch11;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetLotto {

	public static void main(String[] args) {
		Set set = new HashSet();
		
		for (int i = 0;  set.size() < 6; i++) {
			int num = (int)(Math.random()*45)+1;
			set.add(new Integer(num));
		}
		
		List list = new LinkedList(set);
		
		//정렬을 하기 위해서 사용, sort인자로 List인터페이스 타입을 필요로 함.
		//컬렉션에 저장된 객체가 Integer이기 때문에 Integer클래스에 정의된 기본정렬 기준으로 정렬
		Collections.sort(list);
		System.out.println(list);

	}

}
