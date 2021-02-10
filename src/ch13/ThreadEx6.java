package ch13;

import javax.swing.JOptionPane;

/* 싱글쓰레드
 * 사용자가 입력을 마치고 나서야 화면에 숫자가 출력된다
 */
public class ThreadEx6 {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 "+input +"입니다.");
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}

}
