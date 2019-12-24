package practice;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * @author Deep
 *
 */
public class Search2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		
		int col = matrix[0].length - 1;
		int row = 0;
		
		while(col >= 0 && row <= matrix.length - 1) {
			if(target == matrix[row][col]) {
				return true;
			}
			else if(target <= matrix[row][col]) {
				col--;
			}
			else {
				row++;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {

		int[][] input = {
				{1,  4,  7,  11, 15},
				{2,  5,  8,  12, 19},
				{3,  6,  9,  16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		
		System.out.println(searchMatrix(input, 20));
		System.out.println(searchMatrix(input, 13));
	}

}
