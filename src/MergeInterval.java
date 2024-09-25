import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeInterval {
    /**
     * 56. �ϲ�����
     * @param intervals ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ��
     * @return �ϲ������ص������䣬������һ�����ص����������顣
     */
    public static int[][] merge(int[][] intervals) {
        //1.��intervals��������������
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //o1,o2��Ϊintervals��ĳ��Ԫ�أ�o1[0]��������������
                return o1[0] - o2[0];
            }
        });
        //��Ž���ļ���LinkedList����Ԫ����int[]���飬LinkedList�ſ���getLast()
        LinkedList<int[]> res = new LinkedList<>();
        //�ѵ�һ������Ž�ȥ
        res.add(intervals[0]);
        //����������ĵڶ�����ʼ
        for (int i = 1; i < intervals.length; i++) {
            //cur�ǵ�ǰ���ϲ�������
            int[] cur = intervals[i];
            //��resȡ����һ��Ԫ�أ����Ƚ�
            int[] last = res.getLast();
            if (last[1] >= cur[0]) {//�����ص�
                //�ϲ����յ�ȡ���ֵ
                last[1] = Math.max(last[1], cur[1]);
            } else {
                //�����䲻�ص��������������
                res.add(cur);
            }
        }
        return res.toArray(new int[0][0]);

//        LinkedList<int[]> res = new LinkedList<>();
//        // ������� start ��������
//        Arrays.sort(intervals, (a, b) -> {
//            return a[0] - b[0];
//        });
//
//        res.add(intervals[0]);
//        for (int i = 1; i < intervals.length; i++) {
//            int[] curr = intervals[i];
//            // res �����һ��Ԫ�ص�����
//            int[] last = res.getLast();
//            if (curr[0] <= last[1]) {
//                last[1] = Math.max(last[1], curr[1]);
//            } else {
//                // ������һ�����ϲ�����
//                res.add(curr);
//            }
//        }
//        return res.toArray(new int[0][0]);
    }
}
