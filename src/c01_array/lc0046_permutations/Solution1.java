package c01_array.lc0046_permutations;

import java.util.*;

/**
 * This is the solution of No. 46 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/permutations/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * ==========================================================================================================
 *
 * Tags: array;backtracking;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Backtracking
     * The idea is to use backtracking technique to enumerate all the permutations,
     * and by the same time, use a boolean array to mark the numbers that have been
     * enumerated.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * N!)
     * Space Complexity: O(N * N!)
     *
     * References:
     * [1] https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 92.10% of Java online submissions for Permutations.
     * Memory Usage: 39.9 MB, less than 38.19% of Java online submissions for Permutations.
     *
     * @param nums int[], a collection of distinct integers
     * @return List<List<Integer>>, all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> perms = new LinkedList<>();
        List<Integer> path = new ArrayList<>(n);
        boolean[] used = new boolean[n];
        permute(nums, 0, path, used, perms);
        return perms;
    }

    private void permute(int[] nums, int idx, List<Integer> path, boolean[] used, List<List<Integer>> perms) {
        if (idx == nums.length) {
            perms.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            permute(nums, idx + 1, path, used, perms);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution1 solu = new Solution1();
        List<List<Integer>> perms = solu.permute(nums);
        System.out.println(perms);
    }
}