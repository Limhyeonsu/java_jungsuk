package ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* 배열은 각 요소들이 연속적으로 메모리상에 존재하기 때문에 데이터를 읽어오는 것이 빠르다.
 * LinkedList는 불연속적으로 요소들이 연결되어있기 때문에 요소들을 차례대로 따라가야 원하는 값을 읽을 수 있다.
 * 그래서 데이터가 많아질수록 데이터를 읽어로는 접근시간이 길어진다.
 * */
public class ArrayListLinkedListTest2 {
	public static void main(String[] args) {
		
		ArrayList al = new ArrayList(1000000);
		LinkedList ll = new LinkedList();
		add(al);
		add(ll);
		
		System.out.println("=접근 시간 테스트=");
		System.out.println("ArrayList : "+access(al));
		System.out.println("LinkedList : "+access(ll));
		}
	
	public static void add(List list) {
		for (int i = 0; i < 10000; i++)  list.add(i+"");
	}
	
	public static long access(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) list.get(i);
		long end = System.currentTimeMillis();
		return end - start;
	}

}
