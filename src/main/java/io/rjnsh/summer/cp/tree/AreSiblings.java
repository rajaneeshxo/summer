package io.rjnsh.summer.cp.tree;

public class AreSiblings {
    public boolean areSiblings(Node a, Node b, Node root) {
        if (root == null) {
            return false;
        }

        // parent should be same
        return (root.left == a && root.right == b) ||
        (root.right == a && root.left == b) || 
        areSiblings(a, b, root.left) || 
        areSiblings(a, b, root.right);
    }
}
