public class SearchInsert {
    /**
     * 35. ��������λ��
     * @param nums ����һ����������
     * @param target һ��Ŀ��ֵ
     * @return ���������ҵ�Ŀ��ֵ����������������
     * ���Ŀ��ֵ�������������У����������ᱻ��˳������λ��
     * ����ʹ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��
     */
    public static int searchInsert(int[] nums, int target) {
        //˼·�����ֲ���
        /**
         * ��������ģ�壡
         * int left = 0;
         * int right = ...;
         * while (...){ //left �Ƿ�Ҫ���� right
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
