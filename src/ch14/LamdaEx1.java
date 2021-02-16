package ch14;
/* 람다식이란? 메서드를 하나의 식으로 표현한 것 '익명함수'라고도 한다.
 * 람다식을 다루기 위한 인터페이스 '함수형 인터페이스' 오직하나의 추상메서드만 정의되어 있어야 한다.
 */

@FunctionalInterface
interface MyFunction{
	void run();
}

public class LamdaEx1 {
	//매개변수 타입이 MyFuntion
	static void execute(MyFunction f) {
		f.run();
	}
	//반환 타입이 MyFuntion
	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}
	
	public static void main(String[] args) {
		MyFunction f1 = () -> System.out.println("f1.run()");
		
		MyFunction f2 = new MyFunction() {		//익명클래스로 run()구현
			public void run() {	//반드시 public을 붙여야함.
				System.out.println("f2.run()");
			}
		};
		
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( () -> System.out.println("run()"));
	}
}

