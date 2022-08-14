package ch11;

import java.util.*;

/* TreeMap은 이진검색트리의 형태로 데이터를 저장한다. 검색과 정렬에 적합함
 * 검색에 관해서는 HashMap이 더 뛰어나다 단, 범위검색이나 정렬이 필요한 경우에는 TreeMap을 사용하는 것이 좋다.
 * */
public class TreeMapEx1 {
	public static void main(String[] args) {
		String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};
		
		TreeMap map = new TreeMap<>();
		
		for (int i = 0; i < data.length; i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], new Integer(value.intValue()+1));
			}else {
				map.put(data[i],  new Integer(1));
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		//HashMapEx4예제의 결과와 달리 키가 오름차순으로 정렬되어 출력된다.
		System.out.println("= 기본정렬 =");
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : "+printBar('#', value)+" "+value);
		}
		System.out.println();
		
		//map을 ArrayList로 변환한 다음에 sort()로 정렬
		Set set = map.entrySet();
		List list = new ArrayList<>(set);
		
		//내림차순 정렬
		Collections.sort(list, new ValueComparator());
		
		it = list.iterator();
		System.out.println("= 값의 크기가 큰 순서로 정렬 =");
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey()+" : "+printBar('#',  value)+" "+value);
		}
	}
	static class ValueComparator implements Comparator{
		public int compare(Object o1, Object o2) {
			if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry e1 = (Map.Entry)o1;
				Map.Entry e2 = (Map.Entry)o2;
				
				int v1 = ((Integer)e1.getValue()).intValue();
				int v2 = ((Integer)e2.getValue()).intValue();
				return v2 - v1;
			}
			return -1;
		}
	}
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch; 
		}
		return new String(bar);
	}
}
