package io.rjnsh.summer.cp.tree;

public class Depth {
    int depth(Node node, Node root, int currDepth) {
        if (root == null) return 0;

        if (root == node) {
            return currDepth;
        }

        // if node is present in left subtree
        int l = depth(node, root.left, currDepth + 1);
        
        // if node is present in right subtree
        if (l != 0) {
            return currDepth;    
        }

        return depth(node, root.right, currDepth + 1);
    }
}
