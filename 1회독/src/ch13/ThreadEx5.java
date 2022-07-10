package ch13;
/* 멀티쓰레드
 * 멀티쓰레드로 작업시 시간이 더 오래걸리는 이유
 * 1)쓰레드가 번갈아가면서 작업을 처리하기 때문에 쓰레드간의 작업전환시간이 소요된다.
 * 2)한 쓰레드가 화면에 출력하고 있는 동안 다른 쓰레드는 출력이 끝나기를 기다려야 한다. (대기시간 발생)
 */
public class ThreadEx5 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 300; i++) 
			System.out.printf("%s", new String("-"));
		
		System.out.println("소요시간 1 :"+(System.currentTimeMillis() - ThreadEx5.startTime));
			
	}
}

class ThreadEx5_1 extends Thread{
	public void run() {
		for(int i = 0; i < 300; i++)
			System.out.printf("%s", new String("|"));
		
		System.out.println("소요시간 2 :"+(System.currentTimeMillis() - ThreadEx5.startTime));
	}
}
