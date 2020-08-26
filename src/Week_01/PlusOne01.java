package Week_01;

public class PlusOne01 {

    public static void main(String[] args) {
        int[] inta = new int[]{1,2,3,4,9};
        inta = new PlusOne01().plusOne(inta);
        for (int i = 0; i < inta.length; i++)
            System.out.print(inta[i]);

    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = ++digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] a = new int[digits.length + 1];
        a[0] = 1;
        return a;
    }

}
