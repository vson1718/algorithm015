package Week_01;


public class ClimbStairs03 {

    public static void main(String[] args) {
        //1836311903
        System.out.println(climbStairs2(5));
    }


    public static int climbStairs2(int num) {
        if (num <= 3) {
            return num;
        }
        int a = 3, b = 2;
        for (int i = 4; i <= num; i++) {
            a += b;
            b = a - b;
        }
        return a;
    }


}