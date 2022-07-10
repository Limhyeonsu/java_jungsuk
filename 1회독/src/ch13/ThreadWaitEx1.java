package ch13;

import java.util.ArrayList;

/* 특정 쓰레드가 객체의 락을 가진 상태로 오랜시간을 보내지 않게 하는 것도 중요함.
 *  wait() : 쓰레드가 락을 반납하고 기다리게 한다.
 *  notify() : 작업을 중단했던 쓰레드가 다시 락을 얻어 작업을 진행
 *  단, 임의의 쓰레드가 통지를 받는다
 *  동기화 블록내에서만 사용할 수 있다.
 */

//식당에서 음식을 만들어서 테이블에 추가하는 요리사, 손님쓰레드 구현 예제
//동기화 처리를 하지 않았기 때문에 예외 발생함.
public class ThreadWaitEx1 {
	public static void main(String[] args) throws Exception{
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "dount"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();
		
		Thread.sleep(100);
		System.exit(0);
	}
}

class Customer implements Runnable{
	private Table table;
	private String food;
	
	Customer(Table table, String food){
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood())
				System.out.println(name + " ate a "+food);
			else
				System.out.println(name + " failed to eat. : (");
		}
	}
	
	boolean eatFood() { return table.remove(food); }
}

class Cook implements Runnable{
	private Table table;
	
	Cook(Table table) { this.table = table; }
	
	public void run() {
		while(true) {
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(1);
			} catch (Exception e) {}
		}
	}
}

class Table{
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	
	private ArrayList<String> dishes = new ArrayList<>();
	
	public void add(String dish) {
		if(dishes.size() >= MAX_FOOD) return;
		dishes.add(dish);
		System.out.println("Dishes:"+dishes.toString());
	}
	
	public boolean remove(String dishName) {
		for (int i = 0; i < dishes.size(); i++) {
			if(dishName.equals(dishes.get(i))){
				dishes.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public int dishNum() { return dishNames.length; }
}
