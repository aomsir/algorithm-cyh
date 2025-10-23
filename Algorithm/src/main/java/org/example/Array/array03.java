package org.example.Array;

/**
 * 《移动零》
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 思路：
 * 1.快慢指针，slow 指向【0】，fast指向【1】
 * 2.先让slow指针指向为0的数，不为0就一直往后移；
 * 3.fast指针必须指向slow后面的非零数，以便和slow进行交换数值。若fast<slow就一直往后移，直到fast>slow
 *
 */
public class array03 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,0,9,2,0,0,4};
        moveZeroes(nums);
        System.out.print("移动零后的数组：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 1;fast < nums.length; fast ++){
            while(nums[slow] !=0) {
                slow++;
            }
            if(nums[fast] !=0 && slow < fast){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }

        }
    }
}
