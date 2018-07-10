package leetcode;


class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
	}
	
}

// Adding 2 number using Linklist
// ex: L1: 2 -> 4 -> 3
//     L2: 5 -> 6 -> 7  => L3: 7 -> 0 ->0 -> 1
public class addTwoNumbersLinkList {

	public static void main (String args[]) {			
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		
		ListNode l3 = addTwoNumbers(l1, l2);
		// print result
		while (l3 != null) {
			System.out.print(l3.val);
			System.out.print("->");
			l3 = l3.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// create list node with a dummy pointer to head
		ListNode result = new ListNode(-1);
		ListNode store = result;
		int carry = 0;
		
		// case length of 2 linklist equal
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;			
			if (sum > 9) {
				result.next = new ListNode(sum % 10);
				carry = 1;
			}else {
				result.next = new ListNode(sum);
				carry = 0;
			}
			l1 = l1.next;
			l2 = l2.next;
			result = result.next;
		}
		// case l1 is longer
		
		// case l2 is longer		

		// if still have carry
		if (carry > 0) {
			result.next = new ListNode(carry);
			result = result.next;
		}
		return store;
	}
}
