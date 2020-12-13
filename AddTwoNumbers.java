package top_100;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author Deep
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode(0);
        ListNode head = result;

        int carry = 0;

        while(l1 != null  || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;

            carry = sum/10;
            head.next = new ListNode(sum % 10);
            head = head.next;
            
            if (l1 != null) {
            	l1 = l1.next;
            }
            if (l2 != null) {
            	l2 = l2.next;
            }
        }

        if(carry > 0) {
            head.next = new ListNode(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        ListNode r = addTwoNumbers(l1, l2);

        ListNode head = r;
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

 class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }