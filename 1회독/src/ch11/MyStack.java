package ch11;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector{
	public Object push(Object item) {
		addElement(item);
		return item;
	}
	
	public Object pop() {
		Object obj = peek();		//stack에 저장된 마지막 요소를 불러온다.
		removeElementAt(size() -1);		//마지막 요소를 삭제한다.
		return obj;
	}

	public Object peek() {
		int len = size();
		
		if(len == 0) throw new EmptyStackException();
		
		return elementAt(len - 1);	//마지막요소 반환
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public int search(Object o) {
		int i = lastIndexOf(o);		//끝에서부터 객체를 찾는다.
		
		if(i >= 0) {		//객체를 찾은 경우
			return size() - 1;
		}
		return -1;
	}
}
