package io.rjnsh.summer.cp.tree.traversals;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import io.rjnsh.summer.cp.tree.Node;

public class IterativeInorder implements TraversalStrategy {
    List<Integer> traversal;
    public IterativeInorder() {
        this.traversal = new ArrayList<>();
    }
    @Override
    public List<Integer> traverse(Node root) {
        // start with an empty stack
        Deque<Node> stack = new LinkedList<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // push and traverse left
                stack.push(curr);
                curr = curr.left;
            } else if (!stack.isEmpty()) {
                curr = stack.pop();
                // process the current node as left subtree is processed
                curr = curr.right;
            }
        }

        return traversal;
    }

    
}
