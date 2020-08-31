package Week_01;

import java.util.Arrays;

public class PlusOne03 {

    public static void main(String[] args) {
        int[] inta = new int[]{9, 9, 9, 9, 9};
        inta = plusOne(inta);
        for (int i = 0; i < inta.length; i++)
            System.out.print(inta[i]);
    }

    public static int[] plusOne(int[] num) {
        for (int i = num.length - 1; i >= 0; i--) {
            num[i] = (num[i] + 1) % 10;
            if (num[i] != 0) {
                return num;
            }
        }
        int[] nums = new int[num.length + 1];
        nums[0] = 1;
        return nums;
    }
}
