package Week_01;


public class ClimbStairs01 {

    public static void main(String[] args) {
        System.out.println(climbStairs2(47));
    }

    public static int climbStairs(int n) {
        int first = 1;
        int second = 2;
        if (first == n || second == n) {
            return n;
        }
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }

    public static int climbStairs2(int n) {
        int first = 2, second = 3;
        if (n <= 3) {
            return n;
        }
        for (int i = 4; i <= n; i++) {
            second +=  first;
            first = second - first;
        }
        return second;
    }
}
