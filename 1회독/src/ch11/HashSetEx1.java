package ch11;

import java.util.HashSet;
import java.util.Set;
/* set은 중복을 허용하지 않고, 순서를 유지하지 않는다.
 * 저장한 순서를 유지하고 싶으면 LinkedHashSet을 사용해야한다.
 * */
public class HashSetEx1 {

	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2","2","3","3","4","4","4"};
		Set set = new HashSet();
		
		for (int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]);
		}
		System.out.println(set);
		
	}

}
