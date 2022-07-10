package ch13;

public class ThreadEx20 {
	public static void main(String[] args) {
		ThreadEx20_1 gc = new ThreadEx20_1();
		gc.setDaemon(true);
		gc.start();
		
		int requiredMemory = 0;
		
		for (int i = 0; i < 20; i++) {
			requiredMemory = (int)(Math.random() * 10) *20;
			//메모리가 40% 남았을때 interrupt()호출해서 gc()를 수행하도록 한다.
			if(gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
				gc.interrupt();
			}
			
			gc.usedMemory += requiredMemory;
			System.out.println("usedMemory:"+gc.usedMemory);
		}
	}
}

class ThreadEx20_1 extends Thread{
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	public void run() {
		while(true) {
			try {
			//10초마다 가비지 컬렉션을 수행하는 쓰레드 생성
				Thread.sleep(10 * 1000);
			} catch (Exception e) {
				System.out.println("Awaken by interrupt().");
			}
			
			gc();
			System.out.println("Garbage Collected. Free Memory :"+ freeMemory());
		}
	}
	
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) usedMemory = 0;
	}
	
	public int totalMemory() { return MAX_MEMORY; }
	public int freeMemory() { return MAX_MEMORY - usedMemory; }
}