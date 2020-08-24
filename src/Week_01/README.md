####学习总结
#####爬楼梯问题
https://leetcode-cn.com/problems/climbing-stairs/

1.爬楼梯问题总结为斐波拉契数列问题

即 f(n)=f(n-1)+f(n-2)

边界已经给出 
f（1）=1，f（2）=2，f（3）=3  

推导出f（4）=5，f（5）=8

可得f(n)=f(n-1)+f(n-2)

由于1，2，3结果已给出即
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








