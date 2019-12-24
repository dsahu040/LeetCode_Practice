package practice;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/344677
 * @author Deep
 *
 */
public class MinCost {

	public static int minCost(List<Integer> ropes) {
		
		Queue<Integer> queue = new PriorityQueue<>(ropes);
		int totalCost = 0;
		
		while(queue.size() > 1) {
			int cost = queue.poll() + queue.poll();
			queue.add(cost);
			totalCost += cost;
		}
		
		return totalCost;
	}
	
	public static void main(String[] args) {
		
		System.out.println(minCost(Arrays.asList(8, 4, 6, 12)));
		System.out.println(minCost(Arrays.asList(20, 4, 8, 2)));
		System.out.println(minCost(Arrays.asList(1, 2, 5, 10, 35, 89)));
		System.out.println(minCost(Arrays.asList(2, 2, 3, 3)));
	}
}
