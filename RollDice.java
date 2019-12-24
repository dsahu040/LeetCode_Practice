package practice;

/**
 * https://leetcode.com/discuss/interview-question/331158
 * @author Deep
 *
 */
public class RollDice {

	public static int missingNumber(int[] nums) {
		int min = Integer.MAX_VALUE;
		int temp;
		int[] count = new int[7];
		
		for(int num : nums) {
			count[num]++;
		}
		
		for (int i = 1; i < 7; i++) {
			temp = 2 * count[7 - i] + nums.length - count[i] - count[7 - i];
			min = temp < min ? temp : min;
		}
		return min;
	}
	
	public static void main(String[] args) {
		
	    System.out.println(missingNumber(new int[]{1,2,3}));
	    
	    System.out.println(missingNumber(new int[]{1,1,6}));
	    
	    System.out.println(missingNumber(new int[]{1, 6, 2, 3}));
	}
}
