package ch11;
/*문자열의 경우 정렬순서는 문자의 코드값이 기준이 됨
 * 오름차순 정렬 - 공백, 숫자, 대문자, 소문자 순
 * 내림차순 정렬 - 오름차순의 반대
 * */
public class AsciiPrint {

	public static void main(String[] args) {
		char ch = ' ';
		
		for(int i = 0; i < 95; i++)
			System.out.print(ch++);
		// !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		// "[\]^_`abcdefghijklmnopqrstuvwxyz{|}~
	}

}
