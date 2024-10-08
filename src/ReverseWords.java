/**
 * 151. 反转字符串中的单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        // 1. 反转整个字符串
        s = reverse(s, 0, s.length() - 1);

        // 2. 单独反转每个单词
        String[] split = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : split) {
            // 确保单词不为空并反转
            if (!word.isEmpty()) {
                result.append(reverse(word, 0, word.length() - 1)).append(" ");
            }
        }

        // 去掉最后一个空格并返回结果
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    /**
     * 原地反转字符串函数
     */
    public String reverse(String s, int start, int end) {
        char[] arr = s.toCharArray(); // 将字符串转换成字符数组
        while (start < end) {
            // 交换字符
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr); // 再将字符数组转换回字符串
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        System.out.println("中文");
        System.out.println(rw.reverseWords("the sky is blue")); // "blue is sky the"
        System.out.println(rw.reverseWords("  hello world  ")); // "world hello"
        System.out.println(rw.reverseWords("a good   example")); // "example good a"
    }
}
