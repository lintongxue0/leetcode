import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindDiagonalOrder {
    /**
     * 498. 对角线遍历
     * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素，
     * 每次对角线到边界之后，就转换方向遍历。
     * 示例：
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,4,7,5,3,6,8,9]
     * 示例:
     * 输入：mat = [[1,2],[3,4]]
     * 输出：[1,2,3,4]
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        /**
         * 思路一：按照走迷宫的策略来，碰到边界就换方向
         *      1. isRightDir : true则方向为右上，false则方向左下
         *      2. idx代表当前走过的格子数，当 idx < reslut.length，则还没出来
         *      3. 遇到边界，怎么处理，转换方向
         */
        int n = mat.length, m = mat[0].length;
        int[] result = new int[n * m];
        int idx = 0; //代表当前走过的格子数
        int x = 0, y = 0;
        boolean isRightDir = true; //true则方向为右上，false则方向左下

        while (idx < result.length) {
            //1. 当前格的元素放进数组
            result[idx++] = mat[x][y];
            int nextX, nextY;
            //2. 往方向上移一位
            if (isRightDir) { //右上
                nextX = x - 1;
                nextY = y + 1;
            } else { //左下
                nextX = x + 1;
                nextY = y - 1;
            }
            //3. 判断是否越界，越界重新计算下一个坐标
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                if (isRightDir) { //右上的越界有两种
                    nextX = (nextY >= m) ? x+1 : x;
                    nextY = (nextY >= m) ? y : y+1;
                } else { //左下的越界有两种
                    nextY = (nextX >= n) ? y + 1 : y;
                    nextX = (nextX >= n) ? x : x + 1;
                }
                //改变方向
                isRightDir = !isRightDir;
            }
            //4. 更新x,y坐标
            x = nextX;
            y = nextY;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] expected = {1, 2, 4, 7, 5, 3, 6, 8, 9};
        int[] result = findDiagonalOrder(mat);
        assertArrayEquals(expected, result);
    }
}
