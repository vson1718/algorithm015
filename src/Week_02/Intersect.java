package Week_02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Intersect {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{1, 2};
        int[] num = intersect(nums1, nums2);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + ",");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], hashMap.getOrDefault(nums1[i], 0) + 1);
        }
        int[] intersection = new int[nums1.length];
        int index=0;
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i])) {
                intersection[index++]=nums2[i];
                hashMap.put(nums2[i], hashMap.getOrDefault(nums2[i], 0) - 1);
                if (hashMap.getOrDefault(nums2[i], 0) == 0) {
                    hashMap.remove(nums2[i]);
                }
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }
}
