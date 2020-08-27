package Week_01;

import com.sun.tools.classfile.ConstantPool;

public class SwapPairs01 {

    public static void main(String[] a) {
        int[] num = new int[]{1, 2, 3, 4};
        ListNode head = new ListNode(num[0]);
        for (int i = 1; i < num.length; i++) {
            head.add(num[i]);
        }
        swapPairs2(head).print();
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void add(int newVal) {
            ListNode listNode = new ListNode(newVal);
            if (this.next == null) {
                this.next = listNode;
            } else {
                this.next.add(newVal);
            }
        }

        public void print() {
            System.out.println(this.val);
            if (this.next != null) {
                this.next.print();
            }
        }
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode secondNode = head.next;
        head.next = swapPairs(secondNode.next);
        secondNode.next = head;
        return secondNode;
    }


    public static ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode prevNode=dummy;
        while (head!=null&&head.next!=null){
            ListNode firstNode=head;
            ListNode secondNode=head.next;

            prevNode.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;

            prevNode=firstNode;
            head=firstNode.next;
        }
        return dummy.next;
    }
}
