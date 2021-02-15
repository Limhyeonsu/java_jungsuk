package ch13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/* fork & join 프레임웍 : 하나의 작업을 작은 단위로 나누어서 여러 쓰레드가 동시에 처리하는 것을 쉽게 만들어준다.
 * 다음의 두 클래스를 상속받아 compute() 추상메서드 구현하여야 한다. 
 * RecursiveAction : 반환값이 없는 작업 구현
 * RecursiveTask : 반환값이 있는 작업 구현
 * 쓰레드 호출시 start()를 호출하는 것처럼, compute()가 아닌 invoke()호출
 */
public class ForkJoinEx1 {
	static final ForkJoinPool pool = new ForkJoinPool();		//쓰레드 풀 생성
	
	public static void main(String[] args) {
		long from = 1L, to = 100_000_000L;
		
		SumTask task = new SumTask(from, to);
		
		long start = System.currentTimeMillis();
		Long result = pool.invoke(task);
		System.out.println("Elapsed time(4 core):"+(System.currentTimeMillis()-start));
		
		System.out.printf("sum of %d~%d=%d%n", from, to, result);
		System.out.println();
		
		result = 0L;
		start = System.currentTimeMillis();
		for(long i = from; i <= to; i++)
			result += i;
	}
}

class SumTask extends RecursiveTask<Long>{
	long from, to;
	
	public SumTask(Long from, Long to) {
		this.from = from;
		this.to = to;
	}
	//compute() 작업큐에 들어간 작업을 더이상 나눌 수 없을때까지 나눈다.
	public Long compute() {
		long size = to - from + 1;
		
		if(size <= 5)
			return sum();
		
		long half = (from+to)/2;
		
		SumTask leftSum = new SumTask(from, half);
		SumTask rightSum = new SumTask(half+1, to);
		//fork() : 작업을 쓰레드의 작업큐에 넣는 것
		leftSum.fork();
		
		return rightSum.compute() + leftSum.join();
	}
	
	long sum() {
		long tmp = 0L;
		
		for(long i = from; i <= to; i++)
			tmp += i;
		
		return tmp;
	}
}
