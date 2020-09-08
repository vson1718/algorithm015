package Week_03;

import Week_02.MaxDepth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/***
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderTraversal {


    public static void main(String[] a) {
        TreeNode rootNode = new TreeNode(1);
        rootNode.right = new TreeNode(2);
        rootNode.right.left = new TreeNode(3);
        System.out.println(inorderTraversal2(rootNode));
    }


    public static List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while (curr!=null||!stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            arrayList.add(curr.val);
            curr=curr.right;
        }
        return arrayList;
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        helper(root, arrayList);
        return arrayList;
    }

    public static void helper(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, arrayList);
        }
        arrayList.add(root.val);
        if (root.right != null) {
            helper(root.right, arrayList);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
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

}
