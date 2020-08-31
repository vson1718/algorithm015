package Week_01;

public class SwapPairs02 {

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
                next.add(x);
            }
        }

        public void print() {
            System.out.print(val);
            if (next != null) {
                next.print();
            }
        }
    }

    public static void main(String[] a) {
        int[] num = new int[]{1, 2, 3, 4};
        ListNode head = new ListNode(num[0]);
        for (int i = 1; i < num.length; i++) {
            head.add(num[i]);
        }
        swapPairs3(head).print();
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        ListNode firstNode;
        ListNode secondNode;
        while (head != null && head.next != null) {
            firstNode = head;
            secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
//    public static ListNode swapPairs(ListNode head) {
//        if (head==null||head.next==null){
//            return head;
//        }
//        ListNode curNode=head.next;
//        head.next=swapPairs(curNode.next);
//        curNode.next=head;
//        return curNode;
//    }


//    public static ListNode swapPairs(ListNode head) {
//        //给定 1->2->3->4, 你应该返回 2->1->4->3.
//        if (head==null||head.next==null){
//            return head;
//        }
//        ListNode curNode=head.next;
//        head.next=swapPairs(curNode.next);
//        curNode.next=head;
//        return curNode;
//    }


    public static ListNode swapPairs3(ListNode head) {
        //给定 1->2->3->4, 你应该返回 2->1->4->3.
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode preNode = dump, firstNode, secondNode;
        while (head != null && head.next != null) {
            //取出链表的1，2节点
            firstNode = head;
            secondNode = head.next;
            //交换swap
            preNode.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;

            preNode=firstNode;
            head=firstNode.next;
        }
        return dump.next;
    }
}