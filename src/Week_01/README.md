####学习总结

#####爬楼梯问题
https://leetcode-cn.com/problems/climbing-stairs/

######解题思路
1. 爬楼梯问题总结为斐波拉契数列问题
2. 即 f(n)=f(n-1)+f(n-2)
3. 边界已经给出 
4. f（1）=1，f（2）=2，f（3）=3  
5. 推导出f（4）=5，f（5）=8
6. 可得f(n)=f(n-1)+f(n-2)
7. 由于1，2，3结果已给出即
~~~ java
  public static int climbStairs2(int n) {
        int first = 2, second = 3;
        if (n <= 3) {
            return n;
        }
        for (int i = 4; i <= n; i++) {
            second +=  first;//求的第四次数据 f(n)=f(n-1)+f(n-2)
            first = second - first;//求的 f(n-1)的数据
        }
        return second;
    }
~~~
___

##### 加一 问题
https://leetcode-cn.com/problems/plus-one/submissions/

######解题思路
+ 利用遍历数组，在数组的末尾+1，判定末尾+1之后是否满足10进一
+ 若进一：数组的高位+1（高位只能进一）
+ 若不进一：直接返回数组即可
+ 当然还要满足99999999的可能，就是当for正常遍历之后（if条件不满足）
+ 则要扩充数组，new int[digits.length+1]，首位给1即可

~~~ java
  public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > 0; --i) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] newDigits=new int[digits.length+1];
        newDigits[0]=1;
        return newDigits;
    }
~~~
___

#####   两数之和
https://leetcode-cn.com/problems/two-sum/

######解题思路
+ 暴力解法
    + 两个for循环，判断数组两数之和满足目标值target即可
 ~~~ java
  public static int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (target - nums[i] == nums[j]) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{};
  }
 ~~~
+ 利用HashMap数据结构解法
    1. 将（target-num[i]）作为key，i作为value存储
    2. 使用HashMap.containsKey去寻找（target-num[i]）的key
    3. 如果寻找到即HashMap.get(（target-num[i]）)与i为target相加的和的下标
~~~ java
 for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(target - nums[i], i);
            } else {
                return new int[]{hashMap.get(nums[i]), i};
            }
        }
 return new int[]{};
~~~
___
#####  两两交换链表中的节点
https://leetcode-cn.com/problems/swap-nodes-in-pairs/

######解题思路
+ 递归解法
    + 两个出口：当head或head.next为null,则返回head，以及交换之后的ListNode
    + 最小重复子问题： 两两交互 
      + 把head的next指向下一个交换的结果
      + 再把curNode指向head
    + 清空数据：无
~~~ java
 public static ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode curNode=head.next;
        head.next=swapPairs(curNode.next);
        curNode.next=head;
        return curNode;
    }
~~~
+ 非递归解法
    1. 创建一个新链表（dump）指向head，并将dump赋值给preNode（遍历节点的指针）
    2. while将first节点和second节点取出，并交互
    3. 交换后，将重新赋值preNode，head，向下遍历
    4. 返回dump.next(新链表的head)
~~~ java
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
            //交换后，将重新赋值preNode，head，向下遍历
            preNode=firstNode;
            head=firstNode.next;
        }
        return dump.next;
    }
~~~
———
#####  合并两个有序链表
https://leetcode-cn.com/problems/merge-two-sorted-lists/

######解题思路
   >简单理解就是，拿新的节点去将两个链表按照升序链接起来
+ for循环遍历
  1. 首先初始化一个头指针headNode指向链表的head
  2. 根据if条件使用preNode将headNode链表链接起来
  3. 最后判断l1和l2哪一个链表先被链接完，并将未被链完的链表被指向 preNode.next
  4. 返回新链表的next链表

~~~ java
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(-1);
        ListNode preNode = headNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                preNode.next = l2;
                l2 = l2.next;
            } else {
                preNode.next = l1;
                l1 = l1.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1 == null ? l2 : l1;
        return headNode.next;
    }
~~~

+ 递归算法遍历
  1. 出口：最后判断l1和l2哪一个链表先被链接完，返回未链接的完的链表
  2. 重复子问题：根据if条件判断l1和l2哪一个链表链接下一个重复的链表
  5. 返回链表
~~~ java
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
    }
~~~

