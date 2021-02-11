package ch13;
/* 모든 쓰레드는 반드시 쓰레드 그룹에 포함되어 있어야 한다.
 * 쓰레드 그룹을 지정하지 않은 쓰레드는 기본적으로 자신을 생성한 쓰레드와 같은 그룹에 속하게 된다.
 * 
 */
public class ThreadEx9 {
	public static void main(String[] args) throws Exception{
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");
		ThreadGroup subGrp1 = new ThreadGroup(grp1,  "SubGroup1");
		//최대 우선순위 3으로 변경
		grp1.setMaxPriority(3);
		
		Runnable r = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		};
		
		new Thread(grp1, r, "th1").start();
		new Thread(subGrp1, r, "th2").start();
		new Thread(grp2, r, "th3").start();
		
		System.out.println(">>List of ThreadGroup : "+ main.getName() +
				", Active ThreadGroup : "+main.activeGroupCount()+
				", Active Thread : "+ main.activeCount());
		//main쓰레드 그룹의 정보를 출력
		main.list();
		//결과 출력시 쓰레드 구룹에 포함된 하위 쓰레드 그룹, 쓰레드는 들여쓰기를 이용해서 구별되어 출력된다.
	}

}
