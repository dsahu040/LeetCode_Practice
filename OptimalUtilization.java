package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/373202
 * @author Deep
 *
 */
public class OptimalUtilization {

	public List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
		
		Collections.sort(a, (i, j) -> i[1] - j[1]);
		Collections.sort(b, (i, j) -> i[1] - j[1]);
		List<int[]> result = new ArrayList<>();
		
		int max = Integer.MIN_VALUE;
		int a_size = a.size();
		int b_size = b.size();
		
		int i = 0;
		int j = b_size -1;
		
		while(i < a_size && j >= 0) {
			int sum = a.get(i)[1] + b.get(j)[1];
			if(sum > target) {
				--j;
			} else {
				if(max <= sum) {
					if(max <sum) {
						max = sum;
						result.clear();
					} 
					result.add(new int[] {a.get(i)[0], b.get(j)[0]});
					int index = j-1;
					while(index >= 0 && b.get(index)[1] == b.get(index+1)[1]) {
						result.add(new int[] {a.get(i)[0], b.get(index--)[0]});
					}
				}
				++i;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		OptimalUtilization utilization = new OptimalUtilization();
		
		List<int[]> a = new ArrayList<>();
		/*
		 * a.add(new int[] {1, 3}); a.add(new int[] {2, 5}); a.add(new int[] {3, 7});
		 * a.add(new int[] {4, 10});
		 */
		a.add(new int[] {1, 2});
		a.add(new int[] {2, 4});
		a.add(new int[] {3, 6});
		
		List<int[]> b = new ArrayList<>();
		/*
		 * b.add(new int[] {1, 2}); b.add(new int[] {2, 3}); b.add(new int[] {3, 4});
		 * b.add(new int[] {4, 5});
		 */
		b.add(new int[] {1, 2});
		
		List<int[]> result = utilization.getPairs(a, b, 7);
		
		for(int[] i : result) {
			System.out.println(i[0] + " " + i[1]);
		}

	}

}
