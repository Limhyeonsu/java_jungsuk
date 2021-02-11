package ch13;
/* 데몬쓰레드는 일반 쓰레드의 작업을 돕는 보조적인 역할을 하는 쓰레드이다.
 * 일반 쓰레드가 종료되면 데몬 쓰레드는 강제적으로 자동 종료됨
 * 예) 가비지컬렉터, 워드프로세서의 자동저장, 화면자동갱신 등
 */
public class ThreadEx10 implements Runnable{
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx10());
		//데몬쓰레드로 지정, 지정하지 않으면 종료되지 않는다.
		//setDaemon()은 start()를 호출하기 전에 실행되어야 한다!!
		t.setDaemon(true);
		t.start();
		
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
				System.out.println(i);
				
				if(i == 5)
					autoSave = true;
			}
			System.out.println("프로그램을 종료합니다.");
		}

		public void run() {
			//3초마다 자동저장이 무한히 반복, 데몬쓰레드로 지정하지 않으면 종료되지 않는다.
			while(true) {
				try {
					Thread.sleep(3 * 1000);
				} catch (InterruptedException e) {}
				
				if(autoSave) {
					autoSave();
				}
			}
		}
		
		public void autoSave() {
			System.out.println("작업파일이 자동저장되었습니다.");
		}
	}

