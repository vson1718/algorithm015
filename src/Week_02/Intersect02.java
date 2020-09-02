package Week_02;

import java.util.Arrays;
import java.util.HashMap;

public class Intersect02 {
    /***
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] num = intersect(nums1, nums2);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + ",");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], hashMap.getOrDefault(nums1[i], 0) + 1);
        }
        int[] ints = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.getOrDefault(nums2[i], 0) != 0) {
                hashMap.put(nums2[i], hashMap.getOrDefault(nums2[i], 0) - 1);
                ints[index++] = nums2[i];
            }
        }
        return Arrays.copyOfRange(ints, 0, index);
    }
}
