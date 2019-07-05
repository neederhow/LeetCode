package cn.neederhow.leetcode.array;

import java.util.Arrays;

public class ArraysAlgorithm {

    /**
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     *
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     *
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-pivot-index
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums * nums 的长度范围为 [0,10000]。
     *             * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
     * @return [-1,10000]
     *
     * 使用Arrays.stream(nums).sum()，OJ耗时73ms
     * 使用foreach,OJ耗时4ms
     */
    public int pivotIndex(int[] nums){
        return pivotIndex_v3(nums);
    }

    // time: 74ms men: 46 MB
    public int pivotIndex_v1(int[] nums) {
        int left = 0 , right = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (i!=0) left += nums[i-1];
            right -= nums[i];
            if (left == right) return i;
        }
        return -1;
    }

    // time: 73ms men: 40 MB
    public int pivotIndex_v2(int[] nums) {
        int left = 0 , sum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (left * 2 + nums[i] == sum ) return i;
            left += nums[i];
        }
        return -1;
    }

    // time: 4ms men: 37.9 MB
    public int pivotIndex_v3(int[] nums) {
        int left = 0 , sum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (left * 2 + nums[i] == sum ) return i;
            left += nums[i];
        }
        return -1;
    }
}
