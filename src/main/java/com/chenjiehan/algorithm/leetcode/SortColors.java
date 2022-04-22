package com.chenjiehan.algorithm.leetcode;

/**
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors {

    /**
     *      荷兰旗问题
     *      双指针解题法1
     *
     *      解题思路，划分0，1，2的位置
     *         [0,0,0,0,1,1,1,1,2,2,2,2]
     *                A|C......|B    保证A左边永远是0，B右边永远是2，C永远是1 =》循环不变量
     *        遍历C到B的位置，
     *        如果C==2，跟B的数据交换，然后B--，C--
     *        如果C==0，跟A的数据交换，然后A++，C++
     *        如果C==1，则只要C++
     * @param nums
     */
    public void sortColors(int[] nums) {
        int a = 0, b = nums.length - 1;
        for (int i = 0; i <= b; i++) {
            if (nums[i] == 0) {
                swap(nums, i, a);
                a++;
            }
            if (nums[i] == 2) {
                swap(nums, i, b);
                i--;
                b--;
            }
        }
    }

    /**
     * 双指针解题法2
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        // n0表示0的数量索引，n1表示，0和1的数量索引
        int n0 = 0, n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            //记录当前元素到底是什么
            int temp = nums[i];
            //都变成2，因为2没做统计
            nums[i] = 2;
            //如果比2小
            if (temp < 2) {
                //n1指针++，并且赋值为1
                nums[n1++] = 1;
            }
            //如果是0，n0指针++,并且赋值为0
            if (temp ==1) {
                nums[n0++] = 0;
            }
        }
    }


    /**
     * 计数排序（适合数组元素类型足够小的情况）
     * 时间复杂度 O(n+3)
     * 空间复杂度 O(3)
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int[] colorNums = new int[3];
        //统计每种颜色出现的次数
        for (int i : nums) {
            colorNums[i]++;
        }
        int j = 0;
        for (int i = 0; i < 3; i++) {
            int cnt = colorNums[i];
            while (cnt > 0) {
                nums[j++] = i;
                cnt--;
            }
        }
    }


    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
