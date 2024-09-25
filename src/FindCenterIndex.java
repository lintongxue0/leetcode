/**
 * 724. Ѱ������������±�
 */
public class FindCenterIndex {
    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        pre[0] = nums[0];

        //1.�������ó�ǰ׺������pre
        for (int i = 1; i < length; i++) {
            pre[i] = nums[i] + pre[i-1];
        }
        //2.�Ƚ����Ҳ�֮��
        for (int i = 0; i < length; i++) {
            if (pre[i] - nums[i] == pre[length-1] - pre[i])
                return i;
        }
        return -1;
    }
}
