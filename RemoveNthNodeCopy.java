package top_100;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @author Deep
 */
public class RemoveNthNodeCopy {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
       int size = 1;
       ListNode cur = head;
       ListNode p = head;
        while (cur.next != null) {
            size += 1;
            cur = cur.next;
            if (size > n + 1) {
                p = p.next;
            }
        }
        
        if (size == n) {
            return head.next;
        } else {
            p.next = p.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode node = removeNthFromEnd(l1, 2);

        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }