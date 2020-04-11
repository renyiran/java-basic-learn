package com.anthony;


import com.anthony.binarytree.BinaryTree;
import com.anthony.binarytree.Node;

public class TTest {
    public static void main(String[] args) {
        Node root = BinaryTree.init();
        deleteNode(root, 9);
    }

    public static Node deleteNode(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node != null && node.getData() == key && node.getLeftNode() == null && node.getRightNode() == null) {
            return null;
        } else {
            deleteNode(node, key, null);
            return node;
        }
    }

    public static void deleteNode(Node node, int key, Node parentNode) {
        if (key > node.getData()) {
            deleteNode(node.getRightNode(), key, node);
        } else if (key < node.getData()) {
            deleteNode(node.getLeftNode(), key, node);
        } else {
            if (node.getRightNode() != null) {
                Node changeNode = node.getRightNode();
                if (changeNode.getLeftNode() == null) {
                    if (node == parentNode.getRightNode()) {
                        parentNode.setRightNode(changeNode);
                    } else {
                        parentNode.setLeftNode(changeNode);
                    }
                    changeNode.setLeftNode(node.getLeftNode());
                } else {
                    while (changeNode.getLeftNode() != null && changeNode.getLeftNode().getLeftNode() != null) {
                        changeNode = changeNode.getLeftNode();
                    }
                    Node newNode = changeNode.getLeftNode();
                    changeNode.setLeftNode(null);
                    newNode.setLeftNode(node.getLeftNode());
                    newNode.setRightNode(node.getRightNode());
                }
            } else if (node.getLeftNode() != null) {
                Node changeNode = node.getLeftNode();
                if (changeNode.getRightNode() == null) {
                    if (node == parentNode.getRightNode()) {
                        parentNode.setRightNode(node.getLeftNode());
                    } else {
                        parentNode.setLeftNode(node.getLeftNode());
                    }
                    changeNode.setRightNode(node.getRightNode());
                } else {
                    while (changeNode.getRightNode() != null && changeNode.getRightNode().getRightNode() != null) {
                        changeNode = changeNode.getRightNode();
                    }
                    Node newNode = changeNode.getRightNode();
                    changeNode.setRightNode(null);
                    newNode.setLeftNode(node.getLeftNode());
                    newNode.setRightNode(node.getRightNode());
                }
            } else {
                if (node == parentNode.getRightNode()) {
                    parentNode.setRightNode(null);
                } else {
                    parentNode.setLeftNode(null);
                }
            }
        }
    }
}
