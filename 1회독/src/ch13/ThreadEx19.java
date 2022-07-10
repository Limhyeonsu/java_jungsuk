package ch13;


/* join() : 특정 쓰레드의 작업을 지정한 시간동안 기다린다.
 * 시간을 지정하지 않으면 해당 쓰레드가 작업을 모두 마칠때까지 기다리게 된다.
 * 작업 중 다른 쓰레드의 작업이 먼저 수행되어야할 필요가 있을 때 사용
 * interrupt()에 의하여 대기상태에서 벗어난다.
 */
public class ThreadEx19 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx19_1 th1 = new ThreadEx19_1();
		ThreadEx19_2 th2 = new ThreadEx19_2();
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); //main쓰레드가 th1의 작업이 끝날때까지 기다린다.
			th2.join(); //main쓰레드가 th2의 작업이 끝날때까지 기다린다.
		} catch (Exception e) {}
		
		System.out.print("소요시간 : "+(System.currentTimeMillis() - ThreadEx19.startTime));
	}
}

class ThreadEx19_1 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(new String("-"));
		}
	}
}
class ThreadEx19_2 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(new String("|"));
		}
	}
}