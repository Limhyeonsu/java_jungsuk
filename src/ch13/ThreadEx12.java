package ch13;
/* 쓰레드의 실행제어 1.
 * sleep() : 일정시간동안 쓰레드를 멈추게 한다.
 * 항상 try-catch문으로 예외를 처리해주어야 한다.
 */
public class ThreadEx12 {
	public static void main(String[] args) {
		ThreadEx12_1 th1 = new ThreadEx12_1();
		ThreadEx12_2 th2 = new ThreadEx12_2();
		th1.start();
		th2.start();
		
		try {
			/* sleep()은 항상 현재 실행중인 쓰레드에 대해 작동!
			 * th1.sleep(2000);를 호출했어도 실제로 영향받는 것은 main쓰레드이다
			 * 따라서 Thread.sleep();으로 하자
			 */
			th1.sleep(2000);
		} catch (Exception e) {}
		
		System.out.print("<<main 종료>>");
	}
}

class ThreadEx12_1 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.print("<<th1 종료>>");
	}
}

class ThreadEx12_2 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.print("<<th2 종료>>");
	}
}
