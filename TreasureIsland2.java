package practice;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/356150
 * @author Deep
 *
 */
public class TreasureIsland2 {
	
	private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static int minSteps(char[][] grid) {
		Queue<Point> q = collectSources(grid);
		q.add(new Point(0, 0));
		grid[0][0] = 'D';
		
		for(int steps=1; !q.isEmpty(); steps++) {
			for(int sz = q.size(); sz >0; sz--) {
				Point p = q.poll();
				
				for(int[] dir : DIRS) {
					int r = p.r + dir[0];
					int c = p.c + dir[1];
					
					if(isSafe(grid, r, c)) {
						if(grid[r][c] == 'X') {
							return steps;
						}
						grid[r][c] = 'D';
						q.add(new Point(r, c));
					}
				}
			}
		}
		return -1;
	}
	
	private static Queue<Point> collectSources(char[][] grid) {

		Queue<Point> sources = new ArrayDeque<>();
		for(int r=0; r<grid.length; r++) {
			for(int c=0; c<grid[r].length; c++) {
				if(grid[r][c] == 'S') {
					sources.add(new Point(r, c));
				}
			}
		}
		return sources;
	}

	private static boolean isSafe(char[][] grid, int r, int c) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] != 'D';
	}
	
	private static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		char[][] grid = {
	            {'S', 'O', 'O', 'S', 'S'},
	            {'D', 'O', 'D', 'O', 'D'},
	            {'O', 'O', 'O', 'O', 'X'},
	            {'X', 'D', 'D', 'O', 'O'},
	            {'X', 'D', 'D', 'D', 'O'}};
		System.out.println(minSteps(grid));
	}
}
