import java.util.HashSet;

public class SetZeroes {
    /**
     * ������ 01.08. �����
     * ��дһ���㷨����M �� N������ĳ��Ԫ��Ϊ0���������ڵ����������㡣
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        //˼·һ��1.�����õ�0Ԫ�ص����꣬�ŵ�Set���������ظ���key������Map��һ����һ���У�
        //       2.�ٱ���һ�飬�� ��Set.contains(i)����ֵ0����ͬ��
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
