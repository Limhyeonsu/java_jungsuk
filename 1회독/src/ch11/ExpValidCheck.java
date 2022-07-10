package ch11;

import java.util.EmptyStackException;
import java.util.Stack;

public class ExpValidCheck {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage : java ExpValidCheck \"EXPRESSION\"");
			System.out.println("Example : java ExpValidCheck \"((2+3)*1)+3\"");
		}
		
		Stack st = new Stack();
		String expression = args[0];
		
		System.out.println("expression:"+expression);
		
		try{
			for (int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				//여는 괄호를 만나면 stack에 담아줌
				if(ch =='(') {
					st.push(ch+"");
				//닫는 괄호를 만나면 stack에서 꺼냄
				}else if (ch == ')') {
					st.pop();
				}
			}
			if(st.isEmpty()) {
				System.out.println("괄호가 일치합니다.");
			} else {
				System.out.println("괄호가 일치하지 않습니다.");
			}
			
		}catch (EmptyStackException e) {
			System.out.println("괄호가 일치하지 않습니다.");
		}

	}

}
