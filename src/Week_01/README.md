####学习总结
#####爬楼梯问题
https://leetcode-cn.com/problems/climbing-stairs/

1.解题思路
+ 爬楼梯问题总结为斐波拉契数列问题
+ 即 f(n)=f(n-1)+f(n-2)
+ 边界已经给出 
+ f（1）=1，f（2）=2，f（3）=3  
+ 推导出f（4）=5，f（5）=8
+ 可得f(n)=f(n-1)+f(n-2)
+ 由于1，2，3结果已给出即
~~~
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


##### 加一 问题
https://leetcode-cn.com/problems/plus-one/submissions/

1.解题思路
+ 利用遍历数组，在数组的末尾+1，判定末尾+1之后是否满足10进一
+ 若进一：数组的高位+1（高位只能进一）
+ 若不进一：直接返回数组即可
+ 当然还要满足99999999的可能，就是当for正常遍历之后（if条件不满足）
+ 则要扩充数组，new int[digits.length+1]，首位给1即可

~~~
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


#####   两数之和
https://leetcode-cn.com/problems/two-sum/




#####  两两交换链表中的节点
https://leetcode-cn.com/problems/swap-nodes-in-pairs/






