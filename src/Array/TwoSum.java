package Array;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //遍历数组，依次把元素放进Map，放进前判断 Map 里面是否有 target - nums[i]
        //map 的 key 是对应元素，value是下标
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{i, (int) map.get(temp)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
