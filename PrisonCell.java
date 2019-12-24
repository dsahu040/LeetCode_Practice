package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/prison-cells-after-n-days/
 * @author Deep
 *
 */
public class PrisonCell {
	
	/*
	 * public int[] prisonAfterNDays(int[] cells, int N) { for (N = (N - 1) % 14 +
	 * 1; N > 0; --N) { int[] cells2 = new int[8]; for (int i = 1; i < 7; ++i)
	 * cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0; cells = cells2; } return
	 * cells; }
	 */
	
	public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap();
        while (N > 0) {
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
            if (seen.containsKey(Arrays.toString(cells))) {
                N %= seen.get(Arrays.toString(cells)) - N;
            }
        }
    return cells;
    }
	 
	public static void main(String[] args) {
		
		int[] result = new PrisonCell().prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 7);
		
		for(int i : result) {
			System.out.println(i);
		}
	}
}
