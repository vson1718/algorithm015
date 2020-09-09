package Week_03;

import java.util.ArrayList;
import java.util.List;

/***
 *
 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 示例:
 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combine {

    public static void main(String[] a) {
        System.out.println(new Combine().combine(4, 3));
    }

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    private void dfs(int i, int n, int k) {
        if (temp.size() + (n - i + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(i);
        dfs(i + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(i + 1, n, k);
    }

}
