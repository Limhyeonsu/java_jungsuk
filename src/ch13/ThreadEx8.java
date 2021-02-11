package ch13;

public class ThreadEx8 {
	public static void main(String[] args) {
		//th1, th2 모두 main메서드에서 생성했기 때문에 main메서드 쓰레드의 우선순위(5)를 상속받았다.
		ThreadEx8_1 th1 = new ThreadEx8_1();
		ThreadEx8_2 th2 = new ThreadEx8_2();
		//setPriority()를 통해 우선순위 변경
		//우선순위 변경은 start()를 호출 하기전에 해야한다!
		th2.setPriority(7);
		
		System.out.println("Priority of th1(-) : "+th1.getPriority());
		System.out.println("Priority of th2(|) : "+th2.getPriority());
		th1.start();
		th2.start();
	}
}

class ThreadEx8_1 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
			for (int j = 0; j < 10000000; j++);
		}
	}
}

class ThreadEx8_2 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
			for (int j = 0; j < 10000000; j++);
		}
	}
}