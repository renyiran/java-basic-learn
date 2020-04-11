package com.anthony.binarytree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 栈遍历
 */
public class StackTraversal {
    public static void theFirstTraversalStack(Node root) {  //先序遍历
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {  //将所有左孩子压栈
            if (node != null) {   //压栈之前先访问
                BinaryTree.printNode(node);
                stack.push(node);
                node = node.getLeftNode();
            } else {
                node = stack.pop();
                node = node.getRightNode();
            }
        }
    }

    public static void theInOrderTraversalStack(Node root) {  //中序遍历
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);   //直接压栈
                node = node.getLeftNode();
            } else {
                node = stack.pop(); //出栈并访问
                BinaryTree.printNode(node);
                node = node.getRightNode();
            }
        }

    }

    public static void thePostOrderTraversalStack(Node root) {   //后序遍历
        Stack<Node> stack = new Stack<>();
        Stack<Node> output = new Stack<>();//构造一个中间栈来存储逆后序遍历的结果
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRightNode();
            } else {
                node = stack.pop();
                node = node.getLeftNode();
            }
        }

//        Stack<Node> stack = new Stack<>();
//        Stack<Node> outPut = new Stack<>();
//        stack.push(node);
//        while (!stack.isEmpty()) {
//            node = stack.pop();
//            outPut.push(node);
//            if(node.getLeftNode() != null) {
//                stack.push(node.getLeftNode());
//            }
//            if(node.getRightNode() != null) {
//                stack.push(node.getRightNode());
//            }
//        }
//
        while (output.size() > 0) {
            BinaryTree.printNode(output.pop());
        }
    }

    /*
     * 层序遍历（广度优先遍历）
     * */
    public static void LayerOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<Node>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            BinaryTree.printNode(node);
            if (node.getLeftNode() != null) queue.offer(node.getLeftNode());
            if (node.getRightNode() != null) queue.offer(node.getRightNode());
        }
    }

    public static void main(String[] args) {
        Node root = BinaryTree.init();
        System.out.println("先序遍历");
        theFirstTraversalStack(root);
        System.out.println("");
        System.out.println("中序遍历");
        theInOrderTraversalStack(root);
        System.out.println("");
        System.out.println("后序遍历");
        thePostOrderTraversalStack(root);
        System.out.println("");
        System.out.println("层序遍历");
        LayerOrder(root);
    }
}
