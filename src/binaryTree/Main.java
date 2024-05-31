package binaryTree;



public class Main {
	public static void main (String[] args) {
		BinaryTree binarytree= new BinaryTree();
		binarytree.insert(8);
		binarytree.insert(7);
		binarytree.insert(12);
		binarytree.insert(15);
		binarytree.insert(2);
		binarytree.insert(5);
		binarytree.inorder();
	}

}
