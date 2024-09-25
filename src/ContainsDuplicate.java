import java.util.HashMap;

public class ContainsDuplicate {
    /**
     * 217.存在重复的元素
     * @param nums 输入数组
     * @return 存在相同的则true，各不相同则false
     */
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }
}
