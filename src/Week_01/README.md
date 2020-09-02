# 学习方法总结
个人理解就是先要模仿学会，然后再进行理解，最终形成自己的套路。
  
一开始不会很正常，不需要被打击，重点是要踏出舒适区，不断学会新的思路，拓宽知识的广度，并注意把知识串联，不要长时间形成孤岛。
  
弱项一定要加强，至少要形成肌肉记忆。

### 摒弃旧习惯
1、不死磕（传统错误方式）  
2、五毒神掌（敢于放手，死记硬背）  
3、积极看优质题解（国际版和国内版，学习优秀的解法，学会套路，形成自己的套路）  
4、踏出舒适区，强化弱项  

### 反馈
1、主动反馈（自己看优质题解，类比看高手视角打游戏）  
2、被动反馈（高手给意见，做作业助教code review）

### 切题四件套
1、Clarification  确保题意理解正确  
2、Possible Solutions  想所有可能解法  
　　Compare  比较其时空复杂度  
　　Optimal	加强  
3、Coding  
4、Test Case  

### 五毒神掌（五遍刷题法）
1、第一遍  
　　5-10分钟：读题 + 思考  
　　没有思路直接看题解，看各种思路并比较优劣  
　　背诵、默写好的解法
  
2、第二遍  
　　马上自己写，直到提交通过  
　　多种写法都要写，体会其中思路  

3、第三遍  
　　24小时后再做  
　　不同解法的熟练程度进行专项训练  

4、第四遍  
　　一周后回来练习，专项练习  
　　效果：对某一类的解法已经很熟练  

5、第五遍  
　　面试前一周恢复性训练，不一定固定，看情况安排  

###[https://leetcode-cn.com/problems/climbing-stairs/][爬楼梯问题]

###解题思路
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

###[https://leetcode-cn.com/problems/plus-one/submissions/][加一 问题]

###解题思路
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

### [https://leetcode-cn.com/problems/two-sum/][两数之和]
###解题思路
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
###[https://leetcode-cn.com/problems/swap-nodes-in-pairs/][两两交换链表中的节点]

###解题思路
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
### [https://leetcode-cn.com/problems/merge-two-sorted-lists/][合并两个有序链表]
### [合并两个有序链表][https://leetcode-cn.com/problems/merge-two-sorted-lists/]

###解题思路
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