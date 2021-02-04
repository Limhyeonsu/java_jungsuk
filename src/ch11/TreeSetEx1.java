package ch11;

import java.util.TreeSet;

public class TreeSetEx1 {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		
		String from = "b";
		String to = "d";
		
		set.add("abc");			set.add("alien");				set.add("bat");
		set.add("car");			set.add("Car");				set.add("disc");
		set.add("dance");		set.add("dZZZZ");			set.add("dzzzz");
		set.add("elephant");	set.add("elevator");		set.add("fan");
		set.add("flower");
		//대문자가 소문자보다 우선적임
		System.out.println(set);
		System.out.println("range search : from "+from+" to "+to);
		//subSet => 범위검색(시작범위는 포함, 끝 범위는 미포함)
		System.out.println("result1 : "+set.subSet(from, to));
		//끝 범위를 포함시키고자 한다면 끝 범위에 문자열을 붙이면 된다.
		System.out.println("result2 : "+set.subSet(from, to + "zzz"));
	}

}
