public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs 输入字符串数组
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        /**
         * 思路一：
         *      以第一个字符串的字符为准，循环col为字符所在位
         *      内循环每一row的字符串的charAt(col)，做比较，不一样则sub截取返回；
         */
        int row = strs.length;
        int col = strs[0].length(); //以第一个的长度为列

        for (int i = 0; i < col; i++) {
            //以第一个的字符串为准
            char c = strs[0].charAt(i);

            for (int j = 1; j < row; j++) {
                // 等于当前字符串长度时（到头了），结束比较; 或当前字符串和第一个不一样
                if (i == strs[j].length() || strs[j].charAt(i) != c) {

                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
