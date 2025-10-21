package org.example.Array;

/**
 * 《搜索插入位置》
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 *
 */

/**
 * 思路：
 * 1.先获取数组的左右区间 left = 0, right = nums.length - 1; 然后再确定中间索引 middle = (int)(left + right) / 2
 * 2.再判断nums[middle]与target大小关系
 * 3. 3.1 如果nums[middle] > target，则right = middle - 1; middle = (int)(left + right) / 2
 * 3.2 如果nums[middle] < target，则left = middle + 1; middle = (int)(left + right) / 2
 * 3.3 如果nums[middle] = target，直接返回middle
 *
 * 4.如果最后退出循环left > right，表示目标值一直大于此时的right ，同时左边界不断缩减到left=right，
 * 在最后一次循环后变成middle =left = right ，证明目标值不存在数组中，并且要比nums[right]大，比nums[right+1]小，
 * 也就是要插入right+1的位置，所以循环后left=left + 1 ，可以直接返回left或者right + 1
 *
 */




public class array01 {
    public static void main (String[] args) {
        int result = searchInsert(new int[]{1,3,5,6}, 2);
        System.out.println( result);
    }

    public static int searchInsert(int[] nums, int target) {
        int left  = 0 ;
        int right = nums.length - 1;
        while(left <= right){
            int middle = (int)((left + right) / 2);
            if(nums[middle] > target){
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }else {
                return middle;
            }
        }
        return left;
    }
}


