package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/discuss/interview-question/330356
 * @author Deep
 *
 */
public class LongestString {

	public static String generateString(Map<Character, Integer> map) {
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>
																				((a, b) -> b.getValue() - a.getValue());
		int count = 0;
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			count += e.getValue();
			maxHeap.add(e);
		}
		
		Map.Entry<Character, Integer> onHold = null;
		StringBuilder sb = new StringBuilder();
		
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> cur = maxHeap.poll();
			if(cur.getValue() > 0) {
				sb.append(cur.getKey());
			}
			
			if (onHold != null) {
				maxHeap.add(onHold);
				onHold = null;
			}
			
			int curValue = cur.getValue();
			if (curValue > 1) {
				cur.setValue(curValue - 1);
				if(sb.length() >= 2 && cur.getKey() == sb.charAt(sb.length() - 2)) {
					onHold = cur;
				} else {
					maxHeap.add(cur);
				}
			}
		}
		return sb.length() == count ? sb.toString() : "";
 	}
	
	public static void main(String[] args) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('a', 1); 
		map.put('b', 1); 
		map.put('c', 6);
		System.out.println(generateString(map));
		 
		map.clear(); 
		map.put('A', 1); 
		map.put('B', 2); 
		map.put('C', 3);
		System.out.println(generateString(map));
		
		map.clear();
		map.put('A', 5);
		map.put('B', 2);
		map.put('C', 0);
		System.out.println(generateString(map));
	}
}
