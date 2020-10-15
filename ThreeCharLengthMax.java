import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
 * 
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
 * 
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 */
public class ThreeCharLengthMax {
    public static void main(String[] args) {
        // String str =
        // "12345671234561234561234567890abcdefghij1234567890abcde12345678912312";

        String str = "qwertyuiopasdfghjklzxcvbnm";
 
        // String str = "abcdefg abcdef abcdef abcdefghijklmnopqrst abcdefghijklmno
        // abcdefghi abc ab";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(getLengthMax(str));
    }

    /**
     * 错误解法 哈希法
     * 
     * @param input
     * @return
     */
    public static int getLengthMax(String input) {
        int maxLength = 0;
        int lastMaxLength = 0;
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (hashMap.containsKey(String.valueOf(input.charAt(i)))) {
                hashMap.remove(String.valueOf(input.charAt(i)));
                lastMaxLength = lastMaxLength > maxLength ? lastMaxLength : maxLength;
                maxLength = 0;
                System.out.println("i" + i + "=====" + lastMaxLength + "  " + input.charAt(i));
                hashMap.clear();
            }
            maxLength++;
            hashMap.put(String.valueOf(input.charAt(i)), String.valueOf(input.charAt(i)));
        }
        lastMaxLength = lastMaxLength > maxLength ? lastMaxLength : maxLength;
        return lastMaxLength;
    }

    /**
     * 官方正确解法
     * 
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串

            System.out.println("最大为:" + ans + "  比较: " + (rk - i + 1));

            if (rk + 1 == n && rk - i +1 > ans){
                return rk - i +1;
            }
            ans = Math.max(ans, rk - i + 1);
            System.out.println("---"+i);
        }
        return ans;
    }

}
