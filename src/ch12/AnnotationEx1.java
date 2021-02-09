package ch12;

import java.util.ArrayList;

/* 표준애너테이션은 주로 컴파일러를 위한 것으로 컴파일러에게 유용한 정보를 제공한다.
 * */
class Parent {
	void parentMethod() {
	}
}

class Child extends Parent {
	// @Override는 메서드 앞에만 붙일 수 있다. 조상의 메서드를 오버라디딩하는 것이란걸 컴파일러에게 알려주는 역할을 함
	// 오버라이딩을 잘 못하면 알려준다.
	@Override
	void parentmethod() {
	}
}

class NewClass {
	int newField;

	int getNewField() {
		return newField;
	}
	//@Deprecated는 더이상 사용하지 않는 필드나 메서드를 더이상 사용하지 않는 것을 권한다는 의미이다.
	@Deprecated
	int oldField;

	@Deprecated
	int getOldField() {
		return oldField;
	}
}

public class AnnotationEx1 {
	//@SuppressWarnings는 경고메세지가 나타나지 않게 억제해준다.
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		NewClass nc = new NewClass();
		nc.oldField = 10;
		System.out.println(nc.getOldField());
		
		@SuppressWarnings("unchecked")
		ArrayList<NewClass> list = new ArrayList();
		list.add(nc);
	}
}
