package leetCodeQuestions;

import models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {

        TreeNode root = TreeNode.getTreeNode();

        printLevelOrder(root);

        TreeNode result = invertTree(root);

        printLevelOrder(result);
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp.left;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

}
