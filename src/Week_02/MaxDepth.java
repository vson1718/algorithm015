package Week_02;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] a) {
        //[3,9,20,null,null,15,7]，
        TreeNode rootNode = new TreeNode(3);
        rootNode.addLeftNode(9);
        TreeNode right = rootNode.addRightNode(20);
        right.addLeftNode(15);
        right.addRightNode(7);
        System.out.println(maxDepth2(rootNode));
//        rootNode.print();
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode addLeftNode(int x) {
            if (this.left == null) {
                this.left = new TreeNode(x);
            } else {
                return this.left.addLeftNode(x);
            }
            return this.left;
        }

        public TreeNode addRightNode(int x) {
            if (this.right == null) {
                this.right = new TreeNode(x);
            } else {
                return this.right.addLeftNode(x);
            }
            return this.right;
        }

        public void print() {
            System.out.println(this.val);
            if (left != null) {
                left.print();
            }
            if (right != null) {
                right.print();
            }
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }

        return ans;
    }
}
