package ch13;

import javax.swing.JOptionPane;
/* 멀티쓰레드
 * 두 쓰레드가 서로 다른 자원을 사용하는 작업의 경우에는 멀티쓰레드 프로세스가 더 효율적이다.
 * 사용자의 입력을 기다리는 동안에도 다른 쓰레드가 작업을 처리할 수 있기 때문에 보다 효율적인 CPU사용이 가능하다.
 * */
public class ThreadEx7 {

	public static void main(String[] args) {
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 "+input +"입니다.");

	}
}

class ThreadEx7_1 extends Thread{
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (Exception e) {}
		}
	}
}