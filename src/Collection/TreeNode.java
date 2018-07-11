package Collection;

public class TreeNode {
	public String name;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(String data) {
		this.name = data;
	}
	
	
	// in-oder traverse
	public static void inOrderTraverse(TreeNode node) {
		if (node != null) {
			inOrderTraverse(node.left);
			visit(node);
			inOrderTraverse(node.right);
		}
	}
	// pre-order traverse
	public static void preOrderTraverse(TreeNode node) {
		if (node != null) {
			visit(node);
			preOrderTraverse(node.left);
			preOrderTraverse(node.right);
		}
	}
	
	// post-order traverse
	public static void postOrderTraverse(TreeNode node) {
		if (node != null) {
			postOrderTraverse(node.left);
			postOrderTraverse(node.right);
			visit(node);
		}
	}
	
	public static void visit(TreeNode node) {
		System.out.println(node.name);
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode("5");
		node.left = new TreeNode("3");
		node.right = new TreeNode("7");
		
		inOrderTraverse(node);
		System.out.println();
		preOrderTraverse(node);
		System.out.println();
		postOrderTraverse(node);
	}
}
