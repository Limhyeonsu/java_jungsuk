package ch13;
/* start()를 호출하면 새로운 쓰레드가 작업을 실행할 호출스택을 생성후 run()메서드를 호출한다.
 */
public class ThreadEx2 {
	public static void main(String[] args) {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
		//main메서드는 종료되었기 때문에 호출스택에 첫 번째 메서드가 main이 아닌 run임을 확인할 수 있다.
	}
}

class ThreadEx2_1 extends Thread{
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