package LeetCode;

/**
 * 206. Reverse Linked List
 * URL: https://leetcode.com/problems/reverse-linked-list/
 */
public class LeetCode206
{
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {

        // 1 -> 2 -> 3-> 4 -> 5-> NULL

        public ListNode reverseList(ListNode head) {


            if(head == null || head.next == null){
                return head;
            }


            ListNode first  = head;
            ListNode second = first.next;
            ListNode third  = second.next;

            // print(head);

            while(third != null){


                second.next = first;
                first = second;
                second = third;
                third = third.next;

            }
            second.next = first;
            head.next = null;
            head = second;

            // print(head);

            return head;

        }

        public void print(ListNode head){

            ListNode tmp = head;

            while(tmp != null){

                System.out.print(tmp.val+"->");
                tmp = tmp.next;

            }
            System.out.println("Null");
        }

    }
}