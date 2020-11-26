//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 说明：
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
// 示例：
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 提示： 
//
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 695 👎 0

package leetcode.editor.cn;

//Java：合并两个有序数组
/**
 *  //  2 5 7 9 0 0 0  m=4
 *  //  3 4 7          n=3
 * 思路：
    每次比较两个数组最大值.比较大的那个就是当前两个数组中数据的最大。将其放到最后，依次类推。
        - 当i或者j大于等于0的时候,表明两个都还没比较完
        - 当退出一个循环,表示已经有一个数组比较完。
        - 如果是nums2数组比较完了,那么对于nums1剩下的就不用管了，因为本来就有序了。所以我们只要关注当j>=0表名nums2还没比较完。nums2这部分数据也是有序的,直接copy过去覆盖掉剩下的空间即可。

*/

public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
      /*  int[] nums1 = {2,5,8,9,0,0,0};
        int[] nums2 = {3,4,5};
        int[] nums = solution.merge(nums1,4,nums2,3);
        for(int i:nums){
            System.out.println(i);
        }*/
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            if (n == 0)
                return ;
            int i = m - 1;
            int j = n - 1;
            //定位到nums1数组的末尾
            int current_max = nums1.length - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    //比较结果大的被挪到了数组nums1的后面
                    nums1[current_max--] = nums1[i--];
                } else {
                    nums1[current_max--] = nums2[j--];
                }
            }
            while (j >= 0) {
                nums1[current_max--] = nums2[j--];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}