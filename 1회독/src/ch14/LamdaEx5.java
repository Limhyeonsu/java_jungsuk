package ch14;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


/*	함수형인터페이스
 * Supplier : T get() 매개변수는 없고, 반환값만 있음
 * Consumer : void accept(T t) 매개변수만 있고, 반환값이 없음
 * Function : R apply(T t) 하나의 매개변수를 받아서 결과 반환
 * Predicate : boolean test(T t) 조건식을 표현하는데 사용
 */
public class LamdaEx5 {
	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random() *100)+1;
		Consumer<Integer> c = i -> System.out.println(i+", ");
		Predicate<Integer> p = i -> i%2==0;
		Function<Integer, Integer> f = i -> i/10*10;
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomthing(f, list);
		System.out.println(newList);
	}
	
	static <T> List<T> doSomthing(Function<T, T> f, List<T> list){
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		return newList;
	}
	
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for (int i = 0; i < 10; i++) {
			list.add(s.get());
		}
	}
}
