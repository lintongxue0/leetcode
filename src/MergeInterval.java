import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeInterval {
    /**
     * 56. 合并区间
     * @param intervals 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * @return 合并所有重叠的区间，并返回一个不重叠的区间数组。
     */
    public static int[][] merge(int[][] intervals) {
        //1.将intervals按区间的起点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //o1,o2都为intervals的某个元素，o1[0]则代表该区间的起点
                return o1[0] - o2[0];
            }
        });
        //存放结果的集合LinkedList，其元素是int[]数组，LinkedList才可以getLast()
        LinkedList<int[]> res = new LinkedList<>();
        //把第一个区间放进去
        res.add(intervals[0]);
        //从区间数组的第二个开始
        for (int i = 1; i < intervals.length; i++) {
            //cur是当前待合并的区间
            int[] cur = intervals[i];
            //从res取最后的一个元素，来比较
            int[] last = res.getLast();
            if (last[1] >= cur[0]) {//区间重叠
                //合并，终点取最大值
                last[1] = Math.max(last[1], cur[1]);
            } else {
                //该区间不重叠，将其加入结果集
                res.add(cur);
            }
        }
        return res.toArray(new int[0][0]);

//        LinkedList<int[]> res = new LinkedList<>();
//        // 按区间的 start 升序排列
//        Arrays.sort(intervals, (a, b) -> {
//            return a[0] - b[0];
//        });
//
//        res.add(intervals[0]);
//        for (int i = 1; i < intervals.length; i++) {
//            int[] curr = intervals[i];
//            // res 中最后一个元素的引用
//            int[] last = res.getLast();
//            if (curr[0] <= last[1]) {
//                last[1] = Math.max(last[1], curr[1]);
//            } else {
//                // 处理下一个待合并区间
//                res.add(curr);
//            }
//        }
//        return res.toArray(new int[0][0]);
    }
}
