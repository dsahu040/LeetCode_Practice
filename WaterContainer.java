package top_100;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * @author Deep
 */
public class WaterContainer {

    public static int maxArea(int[] height) {
        
        int maxArea = 0;

        for(int left = 0, right = height.length-1; left < right; ) {
            int area = Math.min(height[left], height[right]) * (right -left);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right])
                left++;
            else
                right--; 
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}