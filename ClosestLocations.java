package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * @author Deep
 *
 */
public class ClosestLocations {

	static List<List<Integer>> closestLocation(int totalCrates, List<List<Integer>> allocations, int truckCapacity) {
		
		Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
		for(List<Integer> list : allocations) {
			map.put(list, getDistance(list.get(0), list.get(1)));
		}
		
		Map<List<Integer>, Integer> sortedMap = sort(map);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(Map.Entry<List<Integer>, Integer> e : sortedMap.entrySet()) {
			result.add(e.getKey());
			truckCapacity--;
			if(truckCapacity==0) {
				return result;
			}
			
		}
		return result;
	}

	private  static int getDistance(int x, int y) {
		return x*x + y*y;
	}
	
	private static Map<List<Integer>, Integer> sort(Map<List<Integer>, Integer> map) {
		List<Map.Entry<List<Integer>, Integer>> list = new LinkedList<Map.Entry<List<Integer>,Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<List<Integer>, Integer>>() {
			public int compare(Map.Entry<List<Integer>, Integer> obj1, Map.Entry<List<Integer>, Integer> obj2) {
				return (obj1.getValue().compareTo(obj2.getValue()));
			}
		});
		
		Map<List<Integer>, Integer> temp = new LinkedHashMap<>();
		for(Map.Entry<List<Integer>, Integer> a : list) {
			temp.put(a.getKey(), a.getValue());
		}
		return temp;
	}
	
	public static void main(String[] args) {
		
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		input.add(extracted(2, 1));
		input.add(extracted(4,  3));
		input.add(extracted(-1, 1));
		
		List<List<Integer>> result = closestLocation(3, input, 2);
		
		for(List<Integer> l : result) {
			System.out.println(l.get(0) + " " + l.get(1));
		}
	}

	private static List<Integer> extracted(int a, int b) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(b);
		l.add(a);
		return l;
	}
}
