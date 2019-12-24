package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/discuss/interview-question/372434
 * @author Deep
 *
 */
public class TwoSum_UniquePair {

	public static int uniquePairs(int[] nums, int target) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> seen = new HashSet<Integer>();
		int count = 0;
		
		for(int num : nums) {
			if(set.contains(target-num) && !seen.contains(num)) {
				count++;
				seen.add(num);
				seen.add(target-num);
			} else if (!set.contains(num)) {
				set.add(num);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 45, 46, 46 };
		System.out.println(uniquePairs(nums, 47));
	}
}
