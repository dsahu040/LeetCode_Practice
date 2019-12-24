package practice;

/**
 * https://leetcode.com/discuss/interview-question/376375
 * @author Deep
 *
 */
public class DistanceBST {

	public int bstDistance(int[] nums, int node1, int node2) {
		TreeNode root = buildBST(nums, node1, node2);
		
		if(root == null) {
			return -1;
		}
		
		return distanceBetween(root, node1, node2);
	}
	
	private int distanceBetween(TreeNode root, int node1, int node2) {

		if(root.val > node1 && root.val > node2) {
			return distanceBetween(root.left, node1, node2);
		} else if(root.val < node1 && root.val < node2) {
			return distanceBetween(root.right, node1, node2);
		} else {
			return distanceFromRoot(root, node1) + distanceFromRoot(root, node2);
		}
		
	}

	private TreeNode buildBST(int[] nums, int node1, int node2) {
		TreeNode root = null;
		boolean found1 = false;
		boolean found2 = false;

		for(int val : nums) {
			if(val == node1) found1 = true;
			if(val == node2) found2 = true;
			
			TreeNode node = new TreeNode(val);
			root = addtoBST(root, node);
		}
		if(!found1 || !found2) return null;
		return root;
	}
	
	private TreeNode addtoBST(TreeNode root, TreeNode node) {
		
		if(root == null) {
			root = node;
		} else if (root.val > node.val) {
			root.left = addtoBST(root.left, node);
		} else if(root.val < node.val) {
			root.right = addtoBST(root.right, node);
		}
		return root;
	}

	private int distanceFromRoot(TreeNode root, int val) {
		if(root.val == val) {
			return 0;
		} else if(root.val > val) {
			return 1 + distanceFromRoot(root.left, val);
		} else {
			return 1 + distanceFromRoot(root.right, val);
		}
	}
	
	private class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(new DistanceBST().bstDistance(new int[] {20, 10, 5, 15, 30, 25, 35}, 5, 35));

	}

}
