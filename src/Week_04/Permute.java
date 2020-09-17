package Week_04;

import com.sun.tools.javac.file.SymbolArchive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {

    public static void main(String[] a) {
        int[] num = new int[]{1, 2, 3};
        System.out.println(permute(num));
    }

    private static List<List<Integer>> lists;

    public static List<List<Integer>> permute(int[] nums) {
        lists = new LinkedList<>();
        _permute(new LinkedList<>(), new HashSet<>(), nums, 0);
        return lists;
    }

    private static void _permute(List<Integer> list, HashSet<Integer> hashSet, int[] nums, int i) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (hashSet.contains(nums[j])) {
                continue;
            }
            hashSet.add(nums[j]);
            list.add(nums[j]);
            _permute(list, hashSet, nums, i + 1);
            list.remove(list.size() - 1);
            hashSet.remove(nums[j]);
        }
    }
}
