package Week_02;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        nums = maxSlidingWindow2(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int mMaxSlidingWindowValue;
        int[] mMaxSlidingWindowValues = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length - k+1; i++) {
            mMaxSlidingWindowValue = nums[i];
            for (int j = i; j < i + k; j++) {
                mMaxSlidingWindowValue = Math.max(mMaxSlidingWindowValue, nums[j]);
            }
            mMaxSlidingWindowValues[i] = mMaxSlidingWindowValue;
        }
        return mMaxSlidingWindowValues;
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }

        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
            // 那么为了维持从大到小的原则，我必须让尾部元素弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 不走 while 的话，说明我们正常在队列尾部添加元素
            queue.addLast(i);
            // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
            if (queue.peekFirst() == (i - k)) {
                queue.pollFirst();
            }
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            if (i >= (k - 1)) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
