package ch13;

import java.util.ArrayList;
/* Table의 add(), remove()를 동기화 처리 하였지만,
 * 요리사 쓰레드가 음식을 추가하지 않고 손님 쓰레드가 계속 기다리는 문제 발생
 * 손님 쓰레드가 락을 가지고 기다리고 있기 때문이다. 요리사 쓰레드가 락을 얻어야 음식 추가가 가능함.
 */
public class ThreadWaitEx2 {
	public static void main(String[] args) throws Exception {
		Table2 table = new Table2();

		new Thread(new Cook2(table), "COOK1").start();
		new Thread(new Customer2(table, "dount"), "CUST1").start();
		new Thread(new Customer2(table, "burger"), "CUST2").start();

		Thread.sleep(5000);
		System.exit(0);
	}
}

class Customer2 implements Runnable {
	private Table2 table;
	private String food;

	Customer2(Table2 table, String food) {
		this.table = table;
		this.food = food;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
			String name = Thread.currentThread().getName();

			if (eatFood())
				System.out.println(name + " ate a " + food);
			else
				System.out.println(name + " failed to eat. : (");
		}
	}

	boolean eatFood() {
		return table.remove(food);
	}
}

class Cook2 implements Runnable {
	private Table2 table;

	Cook2(Table2 table) {
		this.table = table;
	}

	public void run() {
		while (true) {
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);

			try {
				Thread.sleep(100);
			} catch (Exception e) {	}
		}
	}
}

class Table2 {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;

	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		if (dishes.size() >= MAX_FOOD)
			return;
		dishes.add(dish);
		System.out.println("Dishes:" + dishes.toString());
	}

	public boolean remove(String dishName) {
		synchronized (this) {
			while (dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");

				try {
					Thread.sleep(500);
				} catch (Exception e) {	}
			}
			for (int i = 0; i < dishes.size(); i++) {
				if (dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public int dishNum() {
		return dishNames.length;
	}
}
