package io.rjnsh.summer.cp.tree.traversals;

import java.util.List;

import io.rjnsh.summer.cp.tree.Node;

@FunctionalInterface
public interface TraversalStrategy {
    List<Integer> traverse(Node root);
}
