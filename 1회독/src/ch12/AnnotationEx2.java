package ch12;

import java.util.Arrays;

class MyArrayList<T>{
	T[] arr;
	
	@SafeVarargs
	@SuppressWarnings("varargs")
	public MyArrayList(T... arr) {
		this.arr = arr;
	}
	
	@SafeVarargs
	public static <T> MyArrayList<T> asList(T... a){
		return new MyArrayList<>(a);
	}
	
	public String toString() {
		return Arrays.toString(arr);
	}
}
public class AnnotationEx2 {
	public static void main(String[] args) {
		MyArrayList<String> list = MyArrayList.asList("1","2","3");
		System.out.println(list);
		// TODO Auto-generated method stub

	}

}
