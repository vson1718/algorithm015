package Week_02;

public class MaxArea {

    public static void main(String[] args) {
        int[] num = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(num));
    }

    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0, curArea;
        while (left < right) {
            curArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, curArea);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
