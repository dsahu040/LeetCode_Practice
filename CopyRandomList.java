package practice;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * @author Deep
 *
 */
public class CopyRandomList {

	private static class Node {
		int val;
		Node next;
		Node random;
		
		Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static Node copyrandom(Node head) {
		Node walker = head;
		Node next = null;
		
		while(walker != null) {
			next = walker.next;
			
			Node copy = new Node(walker.val);
			walker.next = copy;
			copy.next = next;
			
			walker = next;
		}
		
		walker = head;
		while(walker != null) {
			if(walker.random != null) {
				walker.next.random = walker.random.next;
			}
			walker = walker.next.next;
		}
		
		walker = head;
		Node dummy = new Node(0);
		Node cloneListTail = dummy;
		Node copy = null;
		
		while(walker != null) {
			next = walker.next.next;
			copy = walker.next;
			
			cloneListTail.next = copy;
			cloneListTail = copy;
			
			walker.next = next;
			walker = next;
		}
		
		return dummy.next;
	}
	
	private static void printList(Node head) {
		
		Node walker = head;
		
		System.out.println("");
		while(walker != null) {
				System.out.println(" value -> " + walker.val +
								" next -> " + ((walker.next != null) ? walker.next.val : "null") + 
							   " random -> " + ((walker.random != null) ? walker.random.val : "null") + 
							   " NodeObject -> " + walker.toString());
			walker = walker.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {

		Node n1 = new Node(5);
		Node n2 = new Node(3);
		Node n3 = new Node(12);
		Node n4 = new Node(11);
		
		Node head = n1;
		
		head.next = n2;
		head.random = n4;
		
		head.next.next = n3;
		head.next.random = n1;
		
		head.next.next.next = n4;
		head.next.next.random = n2;
		printList(head);
		
		printList(copyrandom(head));
	}

}
