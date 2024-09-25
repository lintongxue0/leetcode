public class SearchInsert {
    /**
     * 35. 搜索插入位置
     * @param nums 给定一个排序数组
     * @param target 一个目标值
     * @return 在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
     * 必须使用时间复杂度为 O(log n) 的算法。
     */
    public static int searchInsert(int[] nums, int target) {
        //思路：二分查找
        /**
         * 二分搜索模板！
         * int left = 0;
         * int right = ...;
         * while (...){ //left 是否要等于 right
         *     int mid = left + (right - left)/2 ;
         *     if (target == nums[mid]){
         *          ...
         *     }else if (target > nums[mid]){
         *          left = ....
         *     } else if (target < nums[mid]) {
         *          right = ...
         *     }
         * }
         * return ...
         */
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return left;
    }
}
