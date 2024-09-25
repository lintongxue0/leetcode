import java.util.HashMap;

public class ContainsDuplicate {
    /**
     * 217.�����ظ���Ԫ��
     * @param nums ��������
     * @return ������ͬ����true��������ͬ��false
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
