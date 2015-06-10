package com.directi;


/*This problem is to find the longest distance between
 *  the leaf nodes in a given binary search tree
 * */
public class DiameterOfTree {
	
	public void createBinarySearchTree(int[] data){
		Node root = new Node();
		root.data = data[0];
		for(int i=1;i<data.length;i++){
			Node node = new Node();
			node.data = data[i];
			recurse(root, node);
		}
		printTreeInOrder(root);
		System.out.println("The diameter of tree is : "+diameterofTree(root));
	}
	
	public void printTreeInOrder(Node root){
		if(root!=null){
			printTreeInOrder(root.left);
			System.out.println(root.data);
			printTreeInOrder(root.right);
		}
		
	}
	
	public int height(Node node){
		int leftHieght=0, rightHieght=0;
		if(node!=null){
			leftHieght = height(node.left)+1;
		}
		if(node!=null){
			rightHieght = height(node.right)+1;
		}
		
		return max(leftHieght, rightHieght);
	}
	
	public int diameterofTree(Node root){
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		System.out.println("Left height is : "+leftHeight);
		System.out.println("Right height is : "+rightHeight);
		return leftHeight+rightHeight+1;
	}
	public int max(int number1, int number2){
		return number1>number2 ? number1 : number2;
	}
	public void recurse(Node rootNode, Node childNode){
		
		if(rootNode!=null){
			if(rootNode.data < childNode.data){
				if(rootNode.right == null){
					rootNode.right=childNode;
				}else{
					recurse(rootNode.right, childNode);
				}
			}else if(rootNode.data > childNode.data){
				if(rootNode.left == null){
					rootNode.left=childNode;
				}else{
					recurse(rootNode.left, childNode);
				}
			}
		}
	}
	
	public static void main(String ... args){
		DiameterOfTree tree = new DiameterOfTree();
		tree.createBinarySearchTree(new int[]{3,6,8,1,2});
		
	}

}
class Node{
	Node left;
	Node right;
	int data;
}