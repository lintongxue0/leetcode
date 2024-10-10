import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindDiagonalOrder {
    /**
     * 498. �Խ��߱���
     * ����һ����СΪ m x n �ľ��� mat �����ԶԽ��߱�����˳����һ�����鷵����������е�����Ԫ�أ�
     * ÿ�ζԽ��ߵ��߽�֮�󣬾�ת�����������
     * ʾ����
     * ���룺mat = [[1,2,3],[4,5,6],[7,8,9]]
     * �����[1,2,4,7,5,3,6,8,9]
     * ʾ��:
     * ���룺mat = [[1,2],[3,4]]
     * �����[1,2,3,4]
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        /**
         * ˼·һ���������Թ��Ĳ������������߽�ͻ�����
         *      1. isRightDir : true����Ϊ���ϣ�false��������
         *      2. idx����ǰ�߹��ĸ��������� idx < reslut.length����û����
         *      3. �����߽磬��ô����ת������
         */
        int n = mat.length, m = mat[0].length;
        int[] result = new int[n * m];
        int idx = 0; //����ǰ�߹��ĸ�����
        int x = 0, y = 0;
        boolean isRightDir = true; //true����Ϊ���ϣ�false��������

        while (idx < result.length) {
            //1. ��ǰ���Ԫ�طŽ�����
            result[idx++] = mat[x][y];
            int nextX, nextY;
            //2. ����������һλ
            if (isRightDir) { //����
                nextX = x - 1;
                nextY = y + 1;
            } else { //����
                nextX = x + 1;
                nextY = y - 1;
            }
            //3. �ж��Ƿ�Խ�磬Խ�����¼�����һ������
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                if (isRightDir) { //���ϵ�Խ��������
                    nextX = (nextY >= m) ? x+1 : x;
                    nextY = (nextY >= m) ? y : y+1;
                } else { //���µ�Խ��������
                    nextY = (nextX >= n) ? y + 1 : y;
                    nextX = (nextX >= n) ? x : x + 1;
                }
                //�ı䷽��
                isRightDir = !isRightDir;
            }
            //4. ����x,y����
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
