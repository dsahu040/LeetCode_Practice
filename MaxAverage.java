package practice;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/349617
 * @author Deep
 *
 */
public class MaxAverage {

	double max = Integer.MIN_VALUE;
	Node res = null;
	
	public int[] computeAvg(Node root){
	    if(root == null) return new int[]{0, 0};
	    
	    int val = root.val; 
	    int count = 1;
	    
	    if(null != root.children) {
	    for(Node child: root.children){
	        int[] arr = computeAvg(child);
	        val += arr[0]; count += arr[1];
	    }
	    }
	    if(count > 1 && (res == null || val / (0.0 + count) > max)){
	        res = root; 
	        max = val / (0.0 + count);
	    }
	    return new int[]{val, count};
	}
	
	public Node subtreeWithMaxAvg(Node root) {
		if(root == null) {
			return null;
		}
		computeAvg(root);
		return res;
	}
	
	public static void main(String[] args) {
		
		Node n11 = new Node(11, null);
		Node n2 = new Node(2, null);
		Node n3 = new Node(3, null);
		Node n15 = new Node(15, null);
		Node n8 = new Node(8, null);
		
		Node n12 = new Node(12, Arrays.asList(n11, n2, n3));
		Node n18 = new Node(18, Arrays.asList(n15, n8));
		Node root = new Node(20, Arrays.asList(n12, n18));
		
		Node result = new MaxAverage().subtreeWithMaxAvg(root);
		System.out.println(result.val);
	}

}

class Node {
	public int val;
	public List<Node> children;
	public Node() {};
	
	public Node(int v, List<Node> nodes ) {
		this.val = v;
		this.children = nodes;
	}
}
