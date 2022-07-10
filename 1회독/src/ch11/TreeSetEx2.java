package ch11;

import java.util.TreeSet;


public class TreeSetEx2 {

	public static void main(String[] args) {
		TreeSet set = new TreeSet<>();
		int[] score = {80, 95, 90, 35, 45, 65, 10, 100};
		
		for(int i = 0; i < score.length; i++)
			set.add(score[i]);
			//set.add(new Integer(score[i]));
		
		//heahSet() 메서드는 지정된 값보다 작은 값의 객체들을 얻어옴
		System.out.println("50보다 작은 값 : "+set.headSet(new Integer(50)));
		//tailSet() 메서드는 지정된 값보다 큰 값의 객체들을 얻어옴
		System.out.println("50보다 큰 값 : "+set.tailSet(new Integer(50)));

	}

}
