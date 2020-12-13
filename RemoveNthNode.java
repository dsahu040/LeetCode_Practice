package top_100;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @author Deep
 */
public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode walker = new ListNode(0);
        walker.next = head;
        ListNode fast = walker;
        ListNode slow = walker;

        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return walker.next;
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