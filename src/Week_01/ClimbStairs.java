package Week_01;


public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(47));
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
}
