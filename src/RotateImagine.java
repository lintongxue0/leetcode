import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateImagine {
    /**
     * 48. 旋转图像
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * 难点在于原地旋转，需直接进行交换swap
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //思路：该思路只适用 n × n
        int n = matrix.length;
        //1. 先用reverse将每一行数据进行倒排，
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i], 0, n - 1);
        }
        //2. 倒排后的矩阵沿 y=x 进行翻转。
        for (int i = 0; i < n; i++) {  //行 0 ~ n
            for (int j = 0; j < n - i; j++) {  //列 依次n, n-1, n-2, ... , 0
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }

    //反转
    public void reverseRow(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void testRotate1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};

        rotate(matrix);

        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate2() {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] expected = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};

        rotate(matrix);

        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate3() {
        int[][] matrix = {{1}};
        int[][] expected = {{1}};

        rotate(matrix);

        Assertions.assertArrayEquals(expected, matrix);
    }
}