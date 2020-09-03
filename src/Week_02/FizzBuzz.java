package Week_02;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] am) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                linkedList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                linkedList.add("Fizz");
            } else if (i % 5 == 0) {
                linkedList.add("Buzz");
            } else {
                linkedList.add(String.valueOf(i));
            }
        }
        return linkedList;
    }
}
