package Week_03;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePrint {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        int[] num = reversePrint(listNode);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
//
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        while (head != null) {
//            //1,4是把head指向head.next
//            ListNode next = head.next;
//            //把当前的head.next指向前一个ListNode
//            head.next = pre;
//            //把前一个指向当前head
//            pre = head;
//
//            head = next;
//        }
//        return pre;
//    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode listNode = head.next;
            head.next = pre;
            pre = head;
            head = listNode;
        }
        return pre;
    }


    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] num = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            num[index++] = stack.pop();
        }
        return num;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void add(int x) {
            if (next == null) {
                next = new ListNode(x);
            } else {
                next.next.add(x);
            }
        }

        public void print() {
            System.out.println(val);
            if (next != null) {
                next.print();
            }
        }
    }
}
