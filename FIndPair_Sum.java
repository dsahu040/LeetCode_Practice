package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/discuss/interview-question/356960
 * @author Deep
 *
 */
public class FIndPair_Sum {

	public static List<Integer> findPair(List<Integer> nums, int target) {
		
		target -= 30;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> result = Arrays.asList(-1, -1);
		
		int largest = 0;
		
		for(int i=0; i<nums.size(); i++) {
			int complement = target - nums.get(i);
			if((nums.get(i) > largest || complement > largest) && map.containsKey(complement)) {
				result.set(0, map.get(complement));
				result.set(1,  i);
				largest = Math.max(complement, nums.get(i));
			}
			map.put(nums.get(i), i);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(findPair(Arrays.asList(1, 10, 25, 35, 60), 90));
		System.out.println(findPair(Arrays.asList(20, 50, 40, 25, 30, 10), 90));
	}

}
