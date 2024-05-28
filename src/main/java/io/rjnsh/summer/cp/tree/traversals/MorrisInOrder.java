package io.rjnsh.summer.cp.tree.traversals;

import java.util.ArrayList;
import java.util.List;

import io.rjnsh.summer.cp.tree.Node;

public class MorrisInOrder implements TraversalStrategy {

    @Override
    public List<Integer> traverse(Node root) {
        List<Integer> traversal = new ArrayList<>();

        Node curr = root;
        Node prev = null;
        while (curr != null) {
            if (curr.left == null) {
                // process node and move to right
                System.out.println("processing as left is null and moving to right " + curr.data);
                traversal.add(curr.data);
                curr = curr.right;
            } else {
                // check if left subree already processed
                prev = curr.left;

                // travel as right as possible, we 
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // if there is already a link, already processed lst
                if (prev.right == null) {
                    // not processed, link and move to left
                    System.out.println("not processed left subtree yet, so linking " + prev.data + " with " + curr.data + " and moving to " + curr.data + " left ");
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    // unlink, process and move to right
                    traversal.add(curr.data);

                    System.out.println("processed subtree with " + curr.data + " and moving to right of " + curr.data + " unlinking ");
                    curr = curr.right;
                    prev.right = null;
                }
            }
        }

        return traversal;
        
    }

    public static void main(String... args) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(7);
        
        
        TraversalStrategy morriStrategy = new MorrisInOrder();
        List<Integer> result = morriStrategy.traverse(root);

        System.out.println(result);

    }
    
}