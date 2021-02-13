package ch13;
/* yield() : 쓰레드 자신에게 주어진 실행시간을 다음 차례의 쓰레드에게 양보
 * interrupt() : 쓰레드가 일시정지 상태에 있을 때 예외를 발생시키는 역할
 */
public class ThreadEx18 {
	public static void main(String[] args) {
		ThreadEx18_1 th1 = new ThreadEx18_1("*");
		ThreadEx18_1 th2 = new ThreadEx18_1("**");
		ThreadEx18_1 th3 = new ThreadEx18_1("***");
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

class ThreadEx18_1 implements Runnable{
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	Thread th;
	
	public ThreadEx18_1(String name) {
		th = new Thread(this, name);
	}
	
	public void run() {
		String name = th.getName();
		
		while(!stopped) {
			if(!suspended) {
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(name + " - interrupted");
				}
			//쓰레드의 실행을 잠시 멈추게 한 상태라면 남은 실행시간을 반복문 안에서 낭비하지 않고 다른 쓰레드에게 양보
			}else {
				Thread.yield();
			}
		}
		System.out.println(name + " - stopped");
	}
	public void suspend() { 
		suspended = true; 
		th.interrupt();
		System.out.println(th.getName() + " - interrupt() by suspend()");
	}
	public void resume() { suspended = false; }
	public void stop() { 
		stopped = true; 
		th.interrupt();
		System.out.println(th.getName() + " - interrupt() by stop()");
	}
	public void start() { th.start(); }
}