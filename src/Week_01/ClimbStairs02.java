package Week_01;

public class ClimbStairs02 {

    public static void main(String[] args) {
        System.out.println(ClimbStairs(4));
    }

    private static int ClimbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int second = 2, third = 3;
        for (int i = 4; i <= n; i++) {
            third += second;
            second = third - second;
        }
        return third;
    }


}
