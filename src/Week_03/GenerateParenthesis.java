package Week_03;

import java.util.ArrayList;
import java.util.List;

/***
 *
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 示例：
 输入：n = 3
 输出：[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis2(3));
    }


    private List list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        _generateParenthesis(0, 0, n, "");
        return list;
    }

    private void _generateParenthesis(int left, int right, int n, String s) {
        if (n == left && n == right) {
            list.add(s);
            return;
        }
        if (left < n) {
            _generateParenthesis(left + 1, right, n, s + "(");
        }
        if (left > right) {
            _generateParenthesis(left, right + 1, n, s + ")");
        }
    }



    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }


    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        //[((())), (()()), (())(), ()(()), ()()()]
    }


}
