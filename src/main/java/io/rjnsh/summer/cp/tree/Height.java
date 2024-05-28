package io.rjnsh.summer.cp.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Height {
    public int height (Node root) {
        if (root == null) {
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);
        return 1 + Math.max(l, r);
    }

    public int heightWithLevelOrder(Node root) {
        int h = 0;
        if (root == null) {
            return h;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();
            h++;
            for (int i = 0;i < levelSize;i++) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return h;
    }
}