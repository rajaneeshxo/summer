package io.rjnsh.summer.cp.tree.traversals;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import io.rjnsh.summer.cp.tree.Node;

public class IterativePostOrder implements TraversalStrategy {

    @Override
    public List<Integer> traverse(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();

        Node curr = root;


        // starting with an empty stack, check for both by starting with curr with root
        return result;
    }
    
}
