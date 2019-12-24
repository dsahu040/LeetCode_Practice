package practice;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author Deep
 *
 */
public class LongestPalindromicSubstring {

	static String longestPalSubstr(String s) { 
		if (s == null || s.length() < 1) {
			return "";
		}
		
		
		int maxlength = 1;
	
		int start = 0;
		int len = s.length();
		
		int low, high;
		
		for(int i = 1; i < len;  ++i) {
			low = i-1;
			high = i;
			
			while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
				if(high - low + 1 > maxlength) {
					start = low;
					maxlength = high - low + 1;
				}
				--low;
				++high;
			}
			
			
			low = i - 1;
			high = i + 1;
			
			while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
				if(high - low + 1 > maxlength) {
					start = low;
					maxlength = high - low + 1;
				}
				--low;
				++high;
			}
		} 
		return s.substring(start, start + maxlength);
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalSubstr("forgeeksskeegfor"));
		System.out.println(longestPalSubstr("xyyxabcdcba"));
		System.out.println(longestPalSubstr("babad"));
		System.out.println(longestPalSubstr("cbbd"));
	}
}
