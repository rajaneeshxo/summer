package io.rjnsh.summer.cp.tree.traversals;

import java.util.ArrayList;
import java.util.List;

import io.rjnsh.summer.cp.tree.Node;

public class Inorder implements TraversalStrategy {
    List<Integer> traversal;

    public Inorder() {
        this.traversal = new ArrayList<>();
    }

    @Override
    public List<Integer> traverse(Node root) {
        if (root == null) {
            return traversal;
        }

        traversal.add(root.data);
        if (root.left != null) {
            traverse(root.left);
        }

        if (root.right != null) {
            traverse(root.right);
        }

        return traversal;
    }
    
}
