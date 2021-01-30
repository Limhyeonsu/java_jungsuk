package datastrucktures;
//1.5 순환 예제
public class Travel {
	public Node start;
	public Travel() {start = null;}
}

class Node{
	private char name;
	private Node left;
	private Node right;
	
	public Node(char newIsland, Node lt, Node rt) {
		this.name = newIsland; 
		this.left = lt;
		this.right = rt;
	}
	public Node() {}

	public Node map() {
		Node n1 = new Node('H', null, null);
		Node n2 = new Node('F', null, null);
		Node n3 = new Node('S', null, null);
		Node n4 = new Node('U', null, null);
		Node n5 = new Node('E', null, null);
		Node n6 = new Node('Z', null, null);
		Node n7 = new Node('K', null, null);
		Node n8 = new Node('N', null, null);
		Node n9 = new Node('A', null, null);
		Node n10 = new Node('Y', null, null);
		Node n11 = new Node('T', null, null);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n5.left = n9;
		n7.right = n10;
		n9.right = null;
		
		return n1;
	}
	public void A_Course(Node n) {
		if(n != null) {
			System.out.print(n.name + "-> ");
			A_Course(n.left);
			A_Course(n.right);
		}
	}
	public void B_Course(Node n) {
		if(n != null) {
			B_Course(n.left);
			System.out.print(n.name + "-> ");
			B_Course(n.right);
		}
	}
	public void C_Course(Node n) {
		if(n != null) {
			C_Course(n.left);
			C_Course(n.right);
			System.out.print(n.name + "-> ");
		}
	}
	
}

class main{
	public static void main(String[] args) {
		Travel travel = new Travel();
		Node node = new Node();
		travel.start = node.map();
		System.out.print("A-코스: ");
		node.A_Course(travel.start);
		System.out.print("\nB-코스: ");
		node.B_Course(travel.start);
		System.out.print("\nC-코스: ");
		node.C_Course(travel.start);
	}
}