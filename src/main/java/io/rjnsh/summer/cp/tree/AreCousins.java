package io.rjnsh.summer.cp.tree;

public class AreCousins {
    // Given a tree and 2 nodes, check if two nodes are cousins
    // levels equal and same parent
    // two traversals -> height of a and b should be equal

    // should be at equal height and should not be siblings
    protected int depth(Node root, Node node, int currLevel) {
        if (root == null) {
            return 0;
        }

        if (root == node) {
            return currLevel;
        }

        int l = depth(root.left, node, currLevel + 1);
        if (l != 0) {
            return l;
        }

        return depth(root.right, node, currLevel + 1);
    }

    protected boolean areSiblings(Node a, Node b, Node root) {
        if (root == null) {
            return false;
        }

        return (root.left == a && root.right == b) 
        || (root.left == b && root.right == a) 
        || areSiblings(a, b, root.left)
        || areSiblings(a, b, root.right);
    }

    protected boolean areCousins(Node a, Node b, Node root) {
        if (root == null) return false;
        // considering root is at depth 1
        int aDepth = depth(root, a, 1);
        int bDepth  = depth(root, b, 1);

        boolean areSiblings = areSiblings(a, b, root);

        return (aDepth == bDepth) && !areSiblings;
    }
    
}


    //          1
    //        /   \
    //       2     3
    //     /   \  /  \
    //    4    5  6   7
    //    and pointer to a node say 5.
    // output should be 6 and 7

    // recursively, should not be a sibling and both trees should be on equal level
    // found in one level
    // 