package string.leetcode003;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 003 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/10
 */
public class Solution4 {
    /**
     * 方法4：滑动窗口（已知字符集）
     * 方法4和方法3的做法是一致的，方法4可以看成是方法3的特例。
     * 如果已知字符串的字符属于哪一种字符集的情况下，可以用大小
     * 固定的数组代替map。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(m)，其中，m表示字符集包含的字符数
     *
     * @param s String, 输入的字符串
     * @return int, 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] index = new int[128];
        for (int l = 0, r = 0; r < s.length(); ++r) {
            l = Math.max(index[s.charAt(r)], l);
            ans = Math.max(r - l + 1, ans);
            index[s.charAt(r)] = r + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println((new Solution4()).lengthOfLongestSubstring(s));
    }
}
