package ch11;

import java.util.Vector;

public class VectorEx1 {

	public static void main(String[] args) {
		Vector v = new Vector<>(5);
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		v.trimToSize(); //빈 공간을 없앤다(용량과 크기가 같아진다.)
		System.out.println("=== After trimToSize() ===");
		print(v);
		
		v.ensureCapacity(6); //용량의 크기를 늘린다.
		System.out.println("=== ensureCapacity(6) ===");
		print(v);
		
		v.setSize(7); //size를 늘린다 (빈공간에는 null값이 들어감 용량도 2배로 늘어남)
		System.out.println("=== After setSize(7) ===");
		print(v);
		
		v.clear(); //값을 비운다 크기가 0으로 변경
		System.out.println("=== After clear() ===");
		print(v);
	}
	
	public static void print(Vector v) {
		System.out.println(v);
		System.out.println("size : "+v.size());
		System.out.println("capacity : "+v.capacity());
	}

}
