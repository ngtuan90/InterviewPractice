package Collection;


class Node {
	Node next = null;
	int data;
	
	public Node (int d) {
		this.data = d;
	}
}
public class LinkedList {
	Node node;
	public LinkedList(Node node) {
		this.node = node;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this.node;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	Node deleteNode(int d) {
		Node n = this.node;
		if (n.data == d) {
			return this.node.next;
		}
		
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			}
			n = n.next;
		}
		return this.node;
	}
}
