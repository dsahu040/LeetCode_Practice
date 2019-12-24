package practice;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * @author Deep
 *
 */
public class Subtree {
	
	private static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	public static boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public static boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public static boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

	public static void main(String[] args) {
		
		TreeNode s4 = new TreeNode(4);
		TreeNode s5 = new TreeNode(5);
		TreeNode s1 = new TreeNode(1);
		TreeNode s2 = new TreeNode(2);
		TreeNode s3 = new TreeNode(3);
		s3.left = s4;
		s3.right = s5;
		s4.left = s1;
		s4.right = s2;
		
		
		TreeNode t4 = new TreeNode(4);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t4.left = t1;
		t4.right = t2;
		
		System.out.println(isSubtree(s3, t4));
	}
}
