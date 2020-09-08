package Week_02;

public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits2(38));
    }

    public static int addDigits(int num) {
        int temp;
        while (num > 10) {
            temp = 0;
            while (num != 0) {
                temp += num % 10;
                num = num / 10;
            }
            num = temp;
        }
        return num;
    }


    public static int addDigits2(int num) {
        if (num < 10) {
            return num;
        }
        int temp = 0;
        while (num != 0) {
            temp += num % 10;
            num = num / 10;
        }
        return addDigits2(temp);
    }

}
