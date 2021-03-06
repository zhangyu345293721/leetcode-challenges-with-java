package linked_list.lc0206_reverse_linked_list;

import entity.ListNode;

/**
 * This is the solution of No. 206 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/28
 */
public class Solution1 {
    /**
     * 解法一：迭代
     * 时间复杂度：O(n)，其中n为链表的长度
     * 空间复杂度：O(1)
     *
     * @param head ListNode, the head of a linked list
     * @return ListNode, the head of the reversed order linked list
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            // reverse a node
            curr.next = prev;
            // update to next iteration
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5});
        System.out.println(head);
        System.out.println((new Solution1()).reverseList(head));
    }
}
