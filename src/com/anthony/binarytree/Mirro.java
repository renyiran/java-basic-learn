package com.anthony.binarytree;

import java.util.Stack;

/**
 * 二叉树镜像
 */
public class Mirro {
    public static void main(String[] args) {
        Node root = BinaryTree.init();
//        recursive(root);
        stack(root);
        BinaryTree.printNode(root);
    }

    //递归
    public static void recursive(Node node) {
        if(node == null) {
            return;
        }
        Node left = node.getLeftNode();
        Node right = node.getRightNode();
        node.setLeftNode(right);
        node.setRightNode(left);
        recursive(left);
        recursive(right);
    }

    public static void stack(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (stack.size() >0) {
            node = stack.pop();
            Node left = node.getLeftNode();
            Node right = node.getRightNode();
            if(left != null) {
                stack.push(left);
            }
            if(right != null) {
                stack.push(right);
            }
            node.setRightNode(left);
            node.setLeftNode(right);
        }

    }
}
