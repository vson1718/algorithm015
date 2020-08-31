package Week_01;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum02 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11,15};
        int target = 9;
        nums = twoSum(nums, target);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(target - nums[i], i);
            } else {
                return new int[]{hashMap.get(nums[i]), i};
            }
        }
        return new int[]{};
    }
}
