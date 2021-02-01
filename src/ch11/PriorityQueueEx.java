package ch11;

import java.util.PriorityQueue;
import java.util.Queue;

/* PriorityQueue
 * 저장한 순서에 관계없이 우선순위가 높은 것부터 꺼내는 특징을 가지고 있다.
 * null은 저장할 수 없다. 저장공간으로 배열을 사용, 각 요소를 '힙'이라는 자료구조의 형태로 저장한다.
 * */
public class PriorityQueueEx {
	public static void main(String[] args) {
		Queue pq = new PriorityQueue();
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);
		
		Object obj = null;
		
		while ((obj = pq.poll()) != null) {
			System.out.println(obj);
		}
	}

}
