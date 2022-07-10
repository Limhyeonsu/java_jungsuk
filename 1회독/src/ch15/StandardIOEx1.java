package ch15;
/* 표준입출력
 * 콘솔을 통한 데이터 입력과 콘솔로의 데이터 출력을 의미한다.
 * System.in / System.out / System.err - 자바 어플리케이션 실행과 동시에 사용할 수 있게 자동적으로 생성, 별도로 스트림을 생성할 필요 없다.
 */
public class StandardIOEx1 {
	public static void main(String[] args) {
		try {
			int input = 0;
			
			while((input = System.in.read()) != -1) //콘솔에 hello입력
				System.out.println("input : "+input+", (char)input : "+(char)input);
			/*
			input : 104, (char)input : h
			input : 101, (char)input : e
			input : 108, (char)input : l
			input : 108, (char)input : l
			input : 111, (char)input : o
			input : 13, (char)input : 

			input : 10, (char)input : 
			콘솔입력은 버퍼를 가지고 있기 때문에 backspace키를 이용해 편집 가능
			Enter키도 사용자 입력으로 간주되어 매 입력마다 \r, \n이 붙기 때문에 불편함이 있다. readLine()을 사용하면 라인단위로 받을수 있어 편리함.
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
