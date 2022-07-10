package ch14;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;


/*	함수형인터페이스 기본형 사용하기
 *	이전 예제는 매개변수, 반환값이 모두 지네릭 타입이었는데 기본형대신 래퍼클래스를 사용하는 것은 비효율적이다
 * 그래서 효율적으로 처리할 수 있도록 기본형을 사용하는 함수형 인터페이스 제공
 */
public class LamdaEx6 {
	public static void main(String[] args) {
		IntSupplier s = () -> (int)(Math.random() *100)+1;
		IntConsumer c = i -> System.out.println(i+", ");
		IntPredicate p = i -> i%2==0;
		IntUnaryOperator op = i -> i/10*10;
		
		int[] arr = new int[10];
		
		makeRandomList(s, arr);
		System.out.println(Arrays.toString(arr));
		printEvenNum(p, c, arr);
		int[]  newArr = doSomthing(op, arr);
		System.out.println(Arrays.toString(newArr));
	}
	
	static int[] doSomthing(IntUnaryOperator op, int[] arr){
		int[]  newArr = new int[arr.length];
		
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = op.applyAsInt(arr[i]) ;
		}
		return newArr;
	}
	
	static  void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
		System.out.print("[");
		for(int i : arr) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
	}
	
	static void makeRandomList(IntSupplier s, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.getAsInt(); 
		}
	}
}
