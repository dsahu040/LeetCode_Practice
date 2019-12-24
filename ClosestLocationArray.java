package practice;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * @author Deep
 *
 */
public class ClosestLocationArray {

	public static int[][] closestLocations(int[][] points, int k) {
		int N = points.length;
		int dists[] = new int[N];
		
		for(int i=0; i<N; ++i) {
			dists[i] = dist(points[i]);
		}
		
		Arrays.sort(dists);
		int distK = dists[k-1];
		
		int[][] ans = new int[k][2];
		int t = 0;
		for(int i = 0; i < N; ++i) {
			if(dist(points[i]) <= distK) {
				ans[t++] = points[i];
			}
		}
		return ans;
	}
	
	public static int dist(int[] point) {
		return point[0]*point[0] + point[1]*point[1];
	}
	
	public static void main(String[] args) {
		int[][] input = new int[3][2];
		input[0][0] = 3;
		input[0][1] = 3;
		input[1][0] = 5;
		input[1][1] = -1;
		input[2][0] = -2;
		input[2][1] = 4;
				
		int[][] result = closestLocations(input, 2);
		System.out.println(result[0][0] + " " + result[0][1]);
		System.out.println(result[1][0] + " " + result[1][1]);
	}
}
