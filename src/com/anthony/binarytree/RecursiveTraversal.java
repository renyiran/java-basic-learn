package com.anthony.binarytree;

/**
 * 递归遍历
 */
public class RecursiveTraversal {
    public static void theFirstTraversal(Node root) {  //先序遍历
        BinaryTree.printNode(root);
        if (root.getLeftNode() != null) {  //使用递归进行遍历左孩子
            theFirstTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null) {  //递归遍历右孩子
            theFirstTraversal(root.getRightNode());
        }
    }
    public static void theInOrderTraversal(Node root) {  //中序遍历
        if (root.getLeftNode() != null) {
            theInOrderTraversal(root.getLeftNode());
        }
        BinaryTree.printNode(root);
        if (root.getRightNode() != null) {
            theInOrderTraversal(root.getRightNode());
        }
    }


    public static void thePostOrderTraversal(Node root) {  //后序遍历
        if (root.getLeftNode() != null) {
            thePostOrderTraversal(root.getLeftNode());
        }
        if(root.getRightNode() != null) {
            thePostOrderTraversal(root.getRightNode());
        }
        BinaryTree.printNode(root);
    }

    public static void main(String[] args) {
        Node root = BinaryTree.init();
        System.out.println("先序遍历");
        theFirstTraversal(root);
        System.out.println("");
        System.out.println("中序遍历");
        theInOrderTraversal(root);
        System.out.println("");
        System.out.println("后序遍历");
        thePostOrderTraversal(root);
        System.out.println("");
    }
}
