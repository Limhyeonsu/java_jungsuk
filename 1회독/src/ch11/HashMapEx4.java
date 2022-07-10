package ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//한정되지 않은 범위의 비순차적인 값들의 빈도수 구하기 
public class HashMapEx4 {

	public static void main(String[] args) {
		String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};
		
		HashMap map = new HashMap();
		
		for (int i = 0; i < data.length; i++) {
			//map에 일치하는 키가 있다면 키의 값을 불러와서 +1해준담에 다시 넣어준다.
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i],  new Integer(value.intValue()+1));
			//일치하는 키가 없다면 키와 값(1)을 넣어준다
			}else {
				map.put(data[i],  new Integer(1));
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey()+" : "+printBar('#', value)+" " +value);
		}
	}
	//값의 수만큼 그래프로 표현
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for (int i = 0; i < bar.length; i++) {
			bar[i]= ch;
			
		}
		return new String(bar);
	}

}
/* 해싱 : 해시함수를 이용해서 데이터를 해시테이블에 저장하고 검색하는 기법
 * 해싱에서 사용하는 자료구조는 배열과 링크드 리스트의 조합으로 되어있다
 * 키를 해시함수에 넣으면 배열의 한 요소를 얻고 배열과 연결된 링크드 리스트에 저장한다.
 * 서로 다른 두 객체에 대해 equals()로 비교한 결과가 true인 동시에 hashCode()의 반환값이 같아야 같은 객체로 인식한다.
 * 새로운 클래스에서 equals() 오버라이딩시 hashCode()도 같이 재정의를 해야만 한다.
 * */
