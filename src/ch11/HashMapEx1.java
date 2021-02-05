package ch11;

import java.util.HashMap;
import java.util.Scanner;

/* HashMap은 Map의 특징인 키와 값을 묶어서 하나의 데이터로 저장한다. 
 * 해싱을 사용하기 때문에 많은 양의 데이터를 검색하는데 뛰어난 성능을 보인다.
 * 키는 저장된 값을 찾는데 사용, 중복이 있어서는 안된다.
 * */
public class HashMapEx1 {

	public static void main(String[] args) {
		HashMap map = new HashMap<>();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		//키가 중복되는 경우 새로 추가된 값이 기존의 값을 덮어 씌운다.
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("id와 password를 입력해주세요");
			System.out.print("id :");
			String id = s.nextLine().trim();
			
			System.out.print("password :");
			String password = s.nextLine().trim();
			System.out.println();
			
			//containsKey() : map에 지정된 키가 포함되어 있는지 알려줌
			if(!map.containsKey(id)) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해 주세요");
				continue;
			}else {
				//get() : 지정된 키의 값을 반환한다.
				if(!(map.get(id).equals(password))) {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요");
				}else {
					System.out.println("id와 비밀번호가 일치합니다.");
					break;
				}
			}
			
		}

	}

}
