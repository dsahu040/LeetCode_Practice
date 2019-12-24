package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * @author Deep
 *
 */
public class MergeIntervals {

	public static int[][] merge(int[][] intervals) {

		if(intervals.length <= 1) {
			return intervals;
		}
		
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		
		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		
		for(int[] interval : intervals) {
			if(interval[0] <= newInterval[1]) {
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			} else {
				newInterval = interval;
				result.add(newInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}
	
	public static void main(String[] args) {
		int[][] result = merge(new int[][] {{1,3},{2,6},{8,10},{15,18}}); 

		for (int[] interval : result) {
			System.out.println("[" + interval[0] + ", " + interval[1] + "]");
		}
	}
}
