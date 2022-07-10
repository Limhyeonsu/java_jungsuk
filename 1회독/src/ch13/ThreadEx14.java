package ch13;

import javax.swing.JOptionPane;

public class ThreadEx14 {

	public static void main(String[] args) {
		ThreadEx14_1 th1 = new ThreadEx14_1();
		th1.start();

		String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + " 입니다.");
		th1.interrupt();
		System.out.println("isInterrupted() : " + th1.isInterrupted());
	}
}

class ThreadEx14_1 extends Thread {
	public void run() {
		int i = 10;

		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				//쓰레드가 멈춰있을때 interrupt() 호출시 예외발생되고 interrupted상태는 false로 자동 초기화 됨
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				interrupt(); //추가해서 interrupted 상태를 true로 바꿔주어야 한다.
			}
		}
		System.out.println("카운트가 종료되었습니다.");
	}
}
