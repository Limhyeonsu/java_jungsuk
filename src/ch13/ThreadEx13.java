package ch13;

import javax.swing.JOptionPane;

/* 쓰레드의 실행제어 2.
 * interrupt(), interrupted() : 쓰레드의 작업을 취소시킨다.
 * 단지 멈추라고 요청할뿐 강제로 종료시키는 것은 아님
 * 예) 쓰레드를 일시정지 상태로 만들고 interrupt()를 호출하면 실행 대기상태로 바뀐다
 */
public class ThreadEx13 {

	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		th1.start();
		
		//사용자의 입력이 끝나야 interrupt() 호출됨 -> interrupted 상태가 true가 됨
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		System.out.println("입력하신 값은 "+input+" 입니다.");
		th1.interrupt();
		System.out.println("isInterrupted() : "+th1.isInterrupted());
	}
}

class ThreadEx13_1 extends Thread{
	public void run() {
		int i = 10;
		
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x = 0; x <2500000000L; x++);
		}
		System.out.println("카운트가 종료되었습니다.");
	}
}
