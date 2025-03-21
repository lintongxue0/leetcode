package Array;

/**
 * 合并两个有序数组：
 * 将两个有序数组合并到第一个数组中（假设第一个数组有足够空间）
 * 第一个数组元素长度m，第二个数组元素长度n，第一个数组总长度m+n；
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 三个指针，i=nums1元素结尾、j=nums2元素结尾、k=从后向前，要插入的位置
         * 谁大就先放进 nums1[k]，确保nums1数据不会被覆盖
         */
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) { //i对应元素大
                nums1[k] = nums1[i];
                i--;
            } else { //j对应元素大，等于也是
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        //如果nums2还有剩余（nums1剩余就无需再动）
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
