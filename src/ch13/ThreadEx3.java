package ch13;

public class ThreadEx3 {

	public static void main(String[] args) {
		ThreadEx3_1 t1 = new ThreadEx3_1();
		t1.run();
		//start()가 아닌 run()을 호출하면 새로운 호출스택이 생성되지 않아 호출스택에 main메서드가 포함되어 있다.
	}

}

class ThreadEx3_1 extends Thread{
	public void run() {
		throwException();
	}
	
	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
