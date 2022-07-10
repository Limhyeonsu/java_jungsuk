package ch13;

public class ThreadEx1 {
	public static void main(String[] args) {
		//1. Thread를 상속받은 경우
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		//2. Runnable인터페이스를 구현한 경우
		Runnable r = new ThreadEx1_2();
		//Runnable인터페이스를 구현한 클래스의 인스턴스를 Thread 생성자의 매개변수로 제공해야한다.
		Thread t2 = new Thread(r);
		//Thread t3 = new Thread(new ThreadEx1_2());  // 한 줄로 작성할 수 있음.
		
		//start()를 호출해야만 쓰레드가 실행된다. (실행X, 실행대기상태에 있다가 OS스케쥴러에 따라 실행순서가 결정됨)
		t1.start();
		t2.start();
		//t3.start();
	}
}

class ThreadEx1_1 extends Thread {
	public void run() {
		for(int i = 0; i < 5; i++) {
			//쓰레드의 이름을 반환
			System.out.println(getName());
		}
	}
}

class ThreadEx1_2 implements Runnable{
	public void run() {
		for (int i = 0; i < 5; i++) {
			//현재 실행중인 쓰레드의 참조를 반환
			System.out.println(Thread.currentThread().getName());
		}
	}
}