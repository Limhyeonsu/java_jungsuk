package ch13;
// 한 쓰레드가 진행중인 작업을 다른 쓰레드가 간섭하지 못하도록 막는 것을 쓰레드의 동기화라고 한다.
public class ThreadEx21 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx21();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class Account{
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	//동기화 설정을 하지 않으면 잔고가 비었음에도 출금작업이 이루어져 음수가 나오는 경우가 발생한다.
	//동기화 하는 방법 2가지
	//1. public synchronized void withdraw(int money) {		메서드 앞에 synchronized 붙여준다.
	public void withdraw(int money) {
		//2. synchronized(this) {		synchronized 블럭으로 감싸준다.
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			balance -= money;
		}
		//}
	}
}

class RunnableEx21 implements Runnable{
	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300 임의의 값을 출금한다.
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:"+acc.getBalance());
		}
	}
}