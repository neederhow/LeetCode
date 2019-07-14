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
     * @return [-1,9999]
     *
     * 使用Arrays.stream(nums).sum()，OJ耗时73ms
     * 使用foreach,OJ耗时4ms
     */
    public int pivotIndex(int[] nums){
        return pivotIndex_v3(nums);
    }

    // time: 74ms men: 46 MB
    private int pivotIndex_v1(int[] nums) {
        int left = 0 , right = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (i!=0) left += nums[i-1];
            right -= nums[i];
            if (left == right) return i;
        }
        return -1;
    }

    // time: 73ms men: 40 MB
    private int pivotIndex_v2(int[] nums) {
        int left = 0 , sum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (left * 2 + nums[i] == sum ) return i;
            left += nums[i];
        }
        return -1;
    }

    // time: 4ms men: 37.9 MB
    private int pivotIndex_v3(int[] nums) {
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

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param digits
     * @returnx
     */
    public int[] plusOne(int[] digits){
        return plusOne_v1(digits);
    }

    // time: 1 ms men: 35.8 MB
    private int[] plusOne_v1(int[] digits) {
        int n =digits.length;
        for (int i = 1; i <= n; i++) {
            if (digits[n-i]<9){
                digits[n-i] = digits[n-i]+1;
                return digits;
            }
            digits[n-i]=0;
        }
        int[] res = new int[n+1];
        res[0]=1;
        return res;
    }

    /**
     *在一个给定的数组nums中，总是存在一个最大元素 。
     *
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     *
     * 如果是，则返回最大元素的索引，否则返回-1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums * nums 的长度范围在[1, 50].
     *             * 每个 nums[i] 的整数范围在 [0, 99].
     * @return [-1, 49]
     */
    public int dominantIndex(int[] nums) {
        return dominantIndex_v2(nums);
    }

    // time: 2 ms men: 35.5 MB
    private int dominantIndex_v1(int[] nums) {
        int index = 0,max = 0, submax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max){
                submax = max;
                max = nums[i];
                index = i;
                continue;
            }
            if (nums[i]>submax) submax = nums[i];
        }
        if (max >= submax * 2) return index;
        return -1;
    }

    // time: 2 ms men: 35.3 MB
    private int dominantIndex_v2(int[] nums){
        int index = 0,max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (max < nums[i] * 2 && i != index) return -1;
        }
        return index;
    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] plusOne(int[] digits) {
        return plusOne_1(digits);
    }

    // time: 1 ms men: 35.8 MB
    public int[] plusOne_1(int[] digits){
        int n =digits.length;
        for (int i = 1; i <= n; i++) {
            if (digits[n-i]<9){
                digits[n-i] = digits[n-i]+1;
                return digits;
            }
            digits[n-i]=0;
        }
        int[] res = new int[n+1];
        res[0]=1;
        return res;
    }
}
