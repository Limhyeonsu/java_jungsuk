package ch13;
/* suspend() : 쓰레드를 멈추게 한다.
 * resume() : suspend()에 의해 정지된 쓰레드를 다시 실행대기 상태로 만든다.
 * stop() : 호출되는 즉시 쓰레드가 종료된다.
 * suspend(), stop()은 교착상태를 일으키기 쉽기 때문에 권장X
 */
public class ThreadEx15 {
	public static void main(String[] args) {
		RunImplEx15 r = new RunImplEx15();
		Thread th1 = new Thread(r,"*");
		Thread th2 = new Thread(r,"**");
		Thread th3 = new Thread(r,"***");
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (Exception e) {}
		
	}
}

class RunImplEx15 implements Runnable{
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			
		}
	}
}
