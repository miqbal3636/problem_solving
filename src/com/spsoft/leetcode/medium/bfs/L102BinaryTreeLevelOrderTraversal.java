package com.spsoft.leetcode.medium.bfs;

import java.util.*;

public class L102BinaryTreeLevelOrderTraversal {

    /**
     * Definition for a binary tree node.
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<TreeNode> q = new ArrayDeque<>();

        q.add(root);

        while (!q.isEmpty()) {

            List<Integer> currentLevel = new ArrayList<>();

            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();

                currentLevel.add(node.val);

                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null)
                    q.offer(left);

                if (right != null)
                    q.offer(right);

            }

            result.add(currentLevel);

        }

        return result;
    }
}
