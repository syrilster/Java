package HackerRankTests;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a Binary Tree, find the max length of the distinct path from root to leaf.
 */
public class BinaryTreeMaxUniquePath {

    static class Tree {
        Tree(int data) {
            this.x = data;
            l = null;
            r = null;
        }

        public int x;
        public Tree l;
        public Tree r;
    }

    public static void main(String[] args) {
        Tree root = new Tree(4);
        root.l = new Tree(5);
        root.r = new Tree(6);
        root.l.l = new Tree(4);
        root.l.l.l = new Tree(5);
        root.r.l = new Tree(1);
        root.r.r = new Tree(6);

        System.out.println("Sum = "
                + maxDistinctPathFromNodeToLeaf(root));

    }

    static int maxDistinctPathFromNodeToLeaf(Tree root) {
        // if tree is NULL, then return
        if (root == null)
            return 0;

        Map<Integer, Integer> nodeHash = new HashMap<>();
        return maxDistinctPathFromNodeToLeaf(root, nodeHash);
    }

    static int maxDistinctPathFromNodeToLeaf(Tree node, Map<Integer, Integer> nodeHash) {
        if (node == null) {
            return nodeHash.size();
        }

        if (nodeHash.containsKey(node.x)) {
            nodeHash.put(node.x, nodeHash.get(node.x) + 1);
        } else {
            nodeHash.put(node.x, 1);
        }

        int maxPath = Math.max(maxDistinctPathFromNodeToLeaf(node.l, nodeHash),
                maxDistinctPathFromNodeToLeaf(node.r, nodeHash));

        if (nodeHash.get(node.x) != null) {
            nodeHash.put(node.x, nodeHash.get(node.x) - 1);
        }

        if (nodeHash.get(node.x) == 0)
            nodeHash.remove(node.x);

        return maxPath;
    }
}
