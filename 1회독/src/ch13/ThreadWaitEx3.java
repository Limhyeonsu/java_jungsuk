package ch13;

import java.util.ArrayList;

public class ThreadWaitEx3 {
	public static void main(String[] args) throws Exception {
		Table3 table = new Table3();

		new Thread(new Cook3(table), "COOK1").start();
		new Thread(new Customer3(table, "dount"), "CUST1").start();
		new Thread(new Customer3(table, "burger"), "CUST2").start();

		Thread.sleep(2000);
		System.exit(0);
	}
}

class Customer3 implements Runnable {
	private Table3 table;
	private String food;

	Customer3(Table3 table, String food) {
		this.table = table;
		this.food = food;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
			String name = Thread.currentThread().getName();

			table.remove(food);
			System.out.println(name + " ate a "+ food);
		}
	}
}


class Cook3 implements Runnable {
	private Table3 table;

	Cook3(Table3 table) {
		this.table = table;
	}

	public void run() {
		while (true) {
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);

			try {
				Thread.sleep(10);
			} catch (Exception e) {	}
		}
	}
}

class Table3 {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;

	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		while (dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting.");
			try {
				wait(); //COOK쓰레드 대기
				Thread.sleep(500);
			} catch (Exception e) {}
		}
		dishes.add(dish);
		notify();  //대기중인 CUST를 깨움
		System.out.println("Dishes:" + dishes.toString());
	}

	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");

				try {
					wait();  //CUST 쓰레드 대기
					Thread.sleep(500);
				} catch (Exception e) {	}
			}
			
			while(true) {
				for (int i = 0; i < dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();   //대기중인 COOK 쓰레드 깨우기
						return;
					}
				}
				
				try {
					System.out.println(name + " is waiting.");
					wait();  //원하는 음식이 없는 CUST 쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch (Exception e) {}
			}
		}
	}

	public int dishNum() {
		return dishNames.length;
	}
}
