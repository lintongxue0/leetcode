/**
 * 724. 寻找数组的中心下标
 */
public class FindCenterIndex {
    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        pre[0] = nums[0];

        //1.遍历，得出前缀和数组pre
        for (int i = 1; i < length; i++) {
            pre[i] = nums[i] + pre[i-1];
        }
        //2.比较左右侧之和
        for (int i = 0; i < length; i++) {
            if (pre[i] - nums[i] == pre[length-1] - pre[i])
                return i;
        }
        return -1;
    }
}
