Traversals

1. [Find nodes whose children have same modulo with K](https://www.geeksforgeeks.org/find-nodes-whose-children-have-same-modulo-with-k/) Can be solved with dfs/bfs. Need access to all children while processing a node. Simple recursion preorder
2. [Largest value in each level of Binary Tree](https://www.geeksforgeeks.org/largest-value-level-binary-tree) level order traversal/using dfs, maintain a map for each level during preorder traversal
3. [Count of Nodes whose children gives same remainder when divided by K](https://www.geeksforgeeks.org/count-of-nodes-whose-children-gives-same-remainder-when-divided-by-k/) bfs or dfs
4. [K Sum Paths](https://www.geeksforgeeks.org/potd-solutions-20-nov-23-k-sum-paths/)

5. [Print all nodes that don’t have sibling](https://www.geeksforgeeks.org/print-nodes-dont-sibling-binary-tree/)
6. [Largest number possible by arranging node values at each level](https://www.geeksforgeeks.org/largest-number-possible-by-arranging-node-values-at-each-level/)use a custom comparator that would sort the numbers in descending order after combining them with each other xy or yx, 3 12, based on 312 and 123, so 3 should come before 12
7. [Odd level sum of given Binary Tree](https://www.geeksforgeeks.org/odd-level-sum-of-given-binary-tree/) easy, pass gp value
8. [Find the level with maximum setbit count in given Binary Tree](https://www.geeksforgeeks.org/find-the-level-with-maximum-setbit-count-in-given-binary-tree/) easy, use the while (n & (n - 1)) count++ technique to count the number of bits