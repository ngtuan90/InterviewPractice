package codefight;

import java.util.*;

public class GetBinaryTreeFromString {

	// (2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))
	// (value left_subtree right_subtree)
	// 5 ≤ tree.length ≤ 120
	// (2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))
	// (2 (7 (2
	// ) (6 (5
	// ) (11
	// ))) (5 () (9 (4

	class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}
	}

	// functin to return the index of close parenthesis
	public static int findIndex(String str, int si, int ei) {
		if (si > ei) {
			return -1;
		}

		// Inbuilt stack
		Stack<Character> s = new Stack<Character>();

		for (int i = si; i <= ei; i++) {

			// if open parenthesis, push it
			if (str.charAt(i) == '(') {
				s.push(str.charAt(i));
			}

			// if close parenthesis
			else if (str.charAt(i) == ')') {
				if (s.peek() == '(') {
					s.pop();

					// if stack is empty, this is
					// the required index
					if (s.empty()) {
						return i;
					}
				}
			}
		}
		// if not found return -1
		return -1;
	}

	// function to construct tree from string
	public static Node treeFromString(String str, int si, int ei) {
		// Base case
		if (si > ei) {
			return null;
		}

		// new root
		Node root = new Node(str.charAt(si) - '0');
		int index = -1;

		// if next char is '(' find the index of
		// its complement ')'
		if (si + 1 <= ei  && str.charAt(si + 1) == '(') {
			index = findIndex(str, si + 1, ei);
		}

		// if index found
		if (index != -1) {

			// call for left subtree
			root.left = treeFromString(str, si + 2, index - 1);

			// call for right subtree
			root.right = treeFromString(str, index + 2, ei - 1);
		}
		return root;
	}

	int[] treeBottom(String tree) {
		// find the empty nodes
		// (value () ())
		// remove the node if the sibling if it have child
		List<String> emptyNodes = new ArrayList<String>();
		String[] split = tree.split("() ()");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			if (split[i].equals("()") && split[i].equals("()")) {
				emptyNodes.add(split[i - 1]);
			}

		}
		return new int[1];
	}

}
