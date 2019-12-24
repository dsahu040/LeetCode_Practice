package practice;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * @author Deep
 *
 */
public class MergeTwoSortedLists {
	
	public ListNode merge(ListNode l1, ListNode l2) {
		
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		if(l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
	
	public void printList(ListNode ln) {
		ListNode walker = ln;
				
		System.out.println("");
		while(walker != null) {
			System.out.println(" -> " + walker.val);
			walker = walker.next;
		}
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		
		MergeTwoSortedLists object = new MergeTwoSortedLists();
		
		ListNode l1 = new ListNode(5);
		l1.next = new ListNode(16);
		l1.next.next = new ListNode(32);
		l1.next.next.next = new ListNode(72);
		l1.next.next.next.next = new ListNode(81);
		System.out.println("First Sorted Linked List");
		
		object.printList(l1);
		
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(48);
		l2.next.next.next = new ListNode(52);
		System.out.println("Second Sorted Linked List");
		object.printList(l2);
		
		System.out.println("Linked List after merge");
		object.printList(object.merge(l1, l2));
	}
}
