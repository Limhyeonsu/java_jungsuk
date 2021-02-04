package ch11;

import java.util.*;

/*TreeSet은 이진검색트리의 자료구조 형태로 데이터를 저장
 * 정렬, 검색, 범위검색에 높은 성능을 보인다.
 * TreeSet은 데이터를 저장할 때 정렬을 하기 때문에 읽어올때 정렬을 할 필요가 없다.
 * */
public class TreeSetLotto {

	public static void main(String[] args) {
		Set set = new TreeSet();
		for(int i = 0; set.size()<6; i++) {
			int num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		System.out.println(set);
	}

}
