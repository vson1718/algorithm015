package Week_02;

import java.util.Stack;

public class RemoveOuterParentheses {

    public static void main(String[] args) {
        //输入："( ()() ) ( () ) ( ()(()) )"
        //输出："()()    ()   () (())"

        String str = "(()()) (()) (()(()))";

        System.out.println(removeOuterParentheses(str));
    }


    public static String removeOuterParentheses(String S) {
        int count = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if ('(' == c) {
                if (count > 0) {
                    stringBuffer.append(c);
                }
                count++;
            } else if (')' == c) {
                count--;
                if (count > 0) {
                    stringBuffer.append(c);
                }
            }
        }
        return stringBuffer.toString();
    }
}
