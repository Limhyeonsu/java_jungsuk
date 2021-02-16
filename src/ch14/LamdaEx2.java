package ch14;
/*	람다식의 타입과 형변환
 * 람다식은 익명 객체이고 타임을 컴파일러가 임의로 정하기 때문에 알 수 없다. 
 * 람다식은 오직 함수형 인터페이스로만 형변환이 가능하다. 형변환 생략 가능
 * Object 타입으로 형변환 X 먼저 함수형 인터페이스로 변환한 뒤에는 Object 타입으로 형변환 가능
 */

@FunctionalInterface
interface MyFuntion2{
	void myMethod();
}

public class LamdaEx2 {
	public static void main(String[] args) {
		MyFuntion2 f = () -> {};
		Object obj = (MyFuntion2) (() -> {});
		String str = ((Object)(MyFuntion2)(()->{})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println(()->{});	에러 : 람다식은 Object타입으로 형변환 안됨
		System.out.println((MyFuntion2)(()-> {}));
//		System.out.println((MyFuntion2)(()-> {}).toString());  에러
		System.out.println(((Object)(MyFuntion2)(()-> {})).toString());
		
// 출력결과를 보면 람다식의 타입이 '외부클래스이름$$Lamda$번호' 형식으로 되어 있다. 
	}

}
