package ch15;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

/* PipedReader / PipedWriter : 쓰레드 간에 데이터를 주고받을 때 사용
 * 입력과 출력스트림을 하나의 스트림으로 연결해서 데이터를 주고받는다.
 * 스트림 생성 후 한쪽 쓰레드에서 connect()를 호출해서 입력스트림과 출력스트림을 연결 
 */
public class PipedReaderWriter {
	public static void main(String[] args) {
		InputThread inThread = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");
		
		//PipedReader와 PipWriter를 연결한다.
		//쓰레드 시작전에 연결을 먼저 해야함
		inThread.connect(outThread.getOutput());
		
		inThread.start();
		outThread.start();
	}
}

class InputThread extends Thread{
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();
	
	InputThread(String name) {
		super(name);
	}
	
	public void run() {
		try {
			int data = 0;
			while((data = input.read()) != -1) {
				sw.write(data);
			}
			System.out.println(getName() + " received : "+ sw.toString());
		} catch (Exception e) {}
	}
	
	public PipedReader getInput() {
		return input;
	}
	
	public void connect(PipedWriter output) {
		try {
			input.connect(output);
		} catch (Exception e) {}
	}
}

class OutputThread extends Thread{
	PipedWriter output = new PipedWriter();
	
	OutputThread(String name){
		super(name);
	}
	
	public void run() {
		try {
			String msg = "Hello";
			System.out.println(getName() + " sent : "+msg);
			output.write(msg);
			output.close();
		} catch (Exception e) {}
	}
	
	public PipedWriter getOutput() {
		return output;
	}
	
	public void connect(PipedReader input) {
		try {
			output.connect(input);
		} catch (Exception e) {}
	}
}