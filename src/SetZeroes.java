import java.util.HashSet;

public class SetZeroes {
    /**
     * 面试题 01.08. 零矩阵
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        //思路一：1.遍历拿到0元素的坐标，放到Set（不会有重复的key，两个Map，一个行一个列）
        //       2.再遍历一遍，当 行Set.contains(i)，则赋值0，列同理
        int row = matrix.length;
        int col = matrix[0].length;
        HashSet<Object> rowSet = new HashSet<>();
        HashSet<Object> colSet = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowSet.contains(i) || colSet.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}
