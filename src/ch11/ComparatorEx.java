package ch11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {

	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strArr);
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분X
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());	//역순정렬
		System.out.println("strArr="+ Arrays.toString(strArr));
	}
}

class Descending implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			//return c1.compareTo(c2) * -1;	//-1을 곱해서 기본 정렬방식의 역순으로 변경
			return c2.compareTo(c1);	//순서를 바꿔도 역순으로 됨
		}
		return -1;
	}
}
