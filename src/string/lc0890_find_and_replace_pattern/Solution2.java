package string.lc0890_find_and_replace_pattern;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This is the solution of No. 890 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/find-and-replace-pattern/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x
 * in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
 * and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 *
 * Note:
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * 题意解读：
     * a word matches pattern <=> 在pattern和word之间存在一对一的映射 <=> pattern和word之间不能有一对多和多对一的情况
     *
     * 解法二：利用一个map
     * 解法二的思路与解法一是一致的，只是在处理pattern和word之间多对一情况时，采用了另一种方式——查看pattern到word之间映射
     * 的值（value）是否唯一。
     *
     * 时间复杂度：O(N * K)，其中N是字符串的数目，K表示字符串的长度
     * 空间复杂度：O(K)
     *
     * Runtime: 2 ms, faster than 79.05% of Java online submissions for Find and Replace Pattern.
     * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Find and Replace Pattern.
     *
     * @param words String[], a list of words
     * @param pattern String, a string represents a pattern
     * @return String[], a list of the words that match the given pattern
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("[ERROR] The input pattern must not be null!!!");
        }
        List<String> ans = new LinkedList<>();
        if (words == null) {
            return ans;
        }
        for (String word : words) {
            if (isMatch(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean isMatch(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(p)) {
                map.put(p, w);
            }
            if (map.get(p) != w) {
                return false;
            }
        }
        boolean[] seen = new boolean[26];
        for (char c : map.values()) {
            if (seen[c - 'a']) {
                return false;
            }
            seen[c - 'a'] = true;
        }
        return true;
    }
}