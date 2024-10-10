public class LongestCommonPrefix {
    /**
     * ��дһ�������������ַ��������е������ǰ׺��
     * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
     *
     * @param strs �����ַ�������
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        /**
         * ˼·һ��
         *      �Ե�һ���ַ������ַ�Ϊ׼��ѭ��colΪ�ַ�����λ
         *      ��ѭ��ÿһrow���ַ�����charAt(col)�����Ƚϣ���һ����sub��ȡ���أ�
         */
        int row = strs.length;
        int col = strs[0].length(); //�Ե�һ���ĳ���Ϊ��

        for (int i = 0; i < col; i++) {
            //�Ե�һ�����ַ���Ϊ׼
            char c = strs[0].charAt(i);

            for (int j = 1; j < row; j++) {
                // ���ڵ�ǰ�ַ�������ʱ����ͷ�ˣ��������Ƚ�; ��ǰ�ַ����͵�һ����һ��
                if (i == strs[j].length() || strs[j].charAt(i) != c) {

                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
