package ch11;

import java.util.*;
import static java.util.Collections.*;

public class CollectionsEx {

	public static void main(String[] args) {
		List list = new ArrayList<>();
		System.out.println(list);

		addAll(list, 1,2,3,4,5);
		System.out.println(list);
		//오른쪽으로 두 칸씩 이동 [4, 5, 1, 2, 3]
		rotate(list, 2);
		System.out.println(list);
		//index 0번째와 2번째를 교환 [1, 5, 4, 2, 3]
		swap(list,  0, 2);
		System.out.println(list);
		//위치를 임의로 변경
		shuffle(list);
		System.out.println(list);
		//정렬  [1, 2, 3, 4, 5]
		sort(list);
		System.out.println(list);
		//역순정렬  [5, 4, 3, 2, 1]
		sort(list, reverseOrder());
		System.out.println(list);
		//3이 저장된 위치의 인덱스를 반환
		int idx = binarySearch(list,  3);
		System.out.println("index of 3 = "+idx);
		
		System.out.println("max="+max(list));
		System.out.println("min="+min(list));
		System.out.println("min="+max(list, reverseOrder()));
		//list를 9로 채운다  [9, 9, 9, 9, 9]
		fill(list,  9);
		System.out.println("list ="+list);
		//list와 같은 크기의 새로운 list 생성 -> 2로 채움  [2, 2, 2, 2, 2]
		List newList = nCopies(list.size(), 2);
		System.out.println("newList="+newList);
		//list와 newList를 비교하여 공통된 요소가 없으면 true 반환
		System.out.println(disjoint(list, newList));
		//list를 newlist의 요소로 복사  [2, 2, 2, 2, 2]
		copy(list,  newList);
		System.out.println("newList="+newList);
		System.out.println("list="+list);
		//list의 요소 2를 1로 변경  [1, 1, 1, 1, 1]
		replaceAll(list,  2,  1);
		System.out.println("list="+list);
		
		Enumeration e = enumeration(list);
		ArrayList list2 = list(e);
		
		System.out.println("list2="+list2);
		
	}

}
