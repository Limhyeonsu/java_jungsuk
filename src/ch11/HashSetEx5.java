package ch11;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx5 {

	public static void main(String[] args) {
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();
		
		setA.add("1");
		setA.add("2");
		setA.add("3");
		setA.add("4");
		setA.add("5");
		System.out.println("A ="+setA);
		
		setB.add("4");
		setB.add("5");
		setB.add("6");
		setB.add("7");
		setB.add("8");
		System.out.println("B ="+setB);
		
		Iterator it = setB.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			//setA에 tmp(setB)객체와 동일한 것이 있는지 확인
			if(setA.contains(tmp))
				setKyo.add(tmp);
		}
		
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			//setA에 tmp(setB)객체와 겹치지 않는 요소들만
			if(!setB.contains(tmp))
				setCha.add(tmp);
		}
		
		//setA와 setB의 모든 요소들을 setHap에 담는다
		it = setA.iterator();
		while(it.hasNext())
				setHab.add(it.next());
			
		it = setB.iterator();
		while(it.hasNext())
			setHab.add(it.next());
		
		System.out.println("A ∩ B = "+setKyo);
		System.out.println("A ∪ B = "+setHab);
		System.out.println("A - B = "+setCha);
	}

}
