import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateImagine {
    /**
     * 48. ��תͼ��
     * ����һ�� n �� n �Ķ�ά���� matrix ��ʾһ��ͼ�����㽫ͼ��˳ʱ����ת 90 �ȡ�
     * ������� ԭ�� ��תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫ ʹ����һ����������תͼ��
     * �ѵ�����ԭ����ת����ֱ�ӽ��н���swap
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //˼·����˼·ֻ���� n �� n
        int n = matrix.length;
        //1. ����reverse��ÿһ�����ݽ��е��ţ�
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i], 0, n - 1);
        }
        //2. ���ź�ľ����� y=x ���з�ת��
        for (int i = 0; i < n; i++) {  //�� 0 ~ n
            for (int j = 0; j < n - i; j++) {  //�� ����n, n-1, n-2, ... , 0
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }

    //��ת
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