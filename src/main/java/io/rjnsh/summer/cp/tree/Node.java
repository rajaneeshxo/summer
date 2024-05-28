package io.rjnsh.summer.cp.tree;

public class Node {
    public Node left;
    public Node right;
    public int data;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.data = data;
        this.right = right;
    }
}

class Tree {
    public Node root;
    public Tree(Node root) {
        this.root = root;
    }
}