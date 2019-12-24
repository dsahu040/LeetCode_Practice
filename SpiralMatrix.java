package practice;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * @author Deep
 *
 */
public class SpiralMatrix {

	public int[][] generateMatrix(int n) {

		int[][] matrix = new int[n][n];
		
		if(n == 0) {
			return matrix;
		}
		
		int row_start = 0;
		int row_end = n - 1;
		int col_start = 0;
		int col_end = n - 1;
		int num = 1;
		
		while(row_start <= row_end && col_start <= col_end) {
			for(int i =col_start; i <= col_end; i++) {
				matrix[row_start][i] = num++;
			}
			row_start++;
			
			for(int i = row_start; i <= row_end; i++) {
				matrix[i][col_end] = num++;
			}
			col_end--;
			
			for(int i =col_end; i >= col_start; i--) {
				matrix[row_end][i] = num++;
			}
			row_end--;
			
			for (int i = row_end; i >= row_start; i--) {
				if (col_start <= col_end) {
					matrix[i][col_start] = num++;
				}
			}
			col_start++;
		}
		
		return matrix;
	}
	
	public static void print(int[][] a, int size) {
		int i, k = 0, l = 0; 
		int m  = size;
		int n = size;
        
        while (k < m && l < n) {  
            for (i = l; i < n; ++i) { 
                System.out.print(a[k][i] + " "); 
            } 
            k++; 
   
            for (i = k; i < m; ++i) { 
                System.out.print(a[i][n - 1] + " "); 
            } 
            n--; 
  
            if (k < m) { 
                for (i = n - 1; i >= l; --i) { 
                    System.out.print(a[m - 1][i] + " "); 
                } 
                m--; 
            } 
  
            if (l < n) { 
                for (i = m - 1; i >= k; --i) { 
                    System.out.print(a[i][l] + " "); 
                } 
                l++; 
            } 
        } 

	}
	
	public static void main(String[] args) {

		int[][] result = new SpiralMatrix().generateMatrix(3);

		print(result, 3);
	}

}
