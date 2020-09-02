
[https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/][两个数组的交集 II]

###解题思路
+ 将一个数组小的进行Hash存储在HashMap中，
    + 将nums1[index]的值为key,出现的次数为value
    + 这样就可以对数组的数据去重复，并统计个数
+ 遍历nums2，在nums2中查找HashMap的中的key即可
~~~
  public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
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
~~~

 
[https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/][滑动窗口的最大值]


[https://leetcode-cn.com/problems/remove-outermost-parentheses/submissions/][删除最外层的括号]

