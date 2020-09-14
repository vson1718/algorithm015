package Week_03;

import java.util.ArrayList;
import java.util.List;

/***
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(new CombinationSum3().combinationSum3(k, n));

    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(lists, combination, k, n, 1);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, List<Integer> combination, int k, int n, int i) {

        if (k == combination.size() && n == 0) {
            lists.add(new ArrayList<>(combination));
            return;
        }
        for (int j = i; j <= 9; j++) {
            combination.add(j);
            dfs(lists, combination, k, n - j, j + 1);
            combination.remove(combination.size() - 1);
        }


    }


//    private void dfs(List<List<Integer>> lists, List<Integer> combination, int k, int n, int position) {
//
//        if (combination.size() == k || n <= 0) {
//            if (combination.size() == k && n == 0) {
//                lists.add(new ArrayList<>(combination));
//            }
//            return;
//        }
//        for (int i = position; i <= 9; i++) {
//            combination.add(i);
//            dfs(lists, combination, k, n - i, i + 1);
//            combination.remove(combination.size() - 1);
//        }
//    }
}
