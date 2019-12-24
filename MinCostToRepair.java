package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/discuss/interview-question/357310
 * @author Deep
 *
 */
public class MinCostToRepair {

	int[] parent;
	int component;
	
	private int find(int v) {
		if(parent[v] == -1) {
			return v;
		}
		return find(parent[v]);
	}
	
	private void connect(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		
		if(p1 == p2) {
			return;
		}
		
		parent[p1] = p2;
		component--;
	}
	
	public int minCostToConnect(int n, int edges[][], int edgerToRepair[][]) {
		parent = new int[n];
		component = n;
		Arrays.fill(parent, -1);
		Set<Integer>[] break_edges = new Set[n];
		
		for (int i = 0; i < n; i++) {
			break_edges[i] = new HashSet<Integer>();
		}
		
		for(int[] edge : edgerToRepair) {
			int u = edge[0] - 1;
			int v = edge[1] - 1;
			break_edges[u].add(v);
			break_edges[v].add(u);
		}
		
		for(int[] edge : edges) {
			int u = edge[0] -1;
			int v = edge[1] -1;
			if(break_edges[u].contains(v)) {
				continue;
			}
			connect(u, v);
		}
		
		Arrays.sort(edgerToRepair, (a, b) -> (a[2] - b[2]));
		int cost = 0;
		for(int i = 0; i < edgerToRepair.length; ++i) {
			if(find(edgerToRepair[i][0] - 1) != find(edgerToRepair[i][1] - 1)) {
				connect(edgerToRepair[i][0] - 1, edgerToRepair[i][1] - 1);
				cost += edgerToRepair[i][2];
				if(component == 1) {
					return cost;
				}
			}
		}
		return -1;
	} 
	
	public static void main(String[] args) {
	
		int[][] edges = new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
		int[][] edgesToRepair = new int[][] {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
		System.out.println(new MinCostToRepair().minCostToConnect(5, edges, edgesToRepair));
		
		edges = new int[][] {{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 5}, {2, 4}, {3, 4}};
		edgesToRepair = new int[][] {{1, 5, 110}, {2, 4, 84}, {3, 4, 79}};
		System.out.println(new MinCostToRepair().minCostToConnect(6, edges, edgesToRepair));
		
		edges = new int[][] {{1, 2}, {2, 3}, {4, 5}, {3, 5}, {1, 6}, {2, 4}};
		edgesToRepair = new int[][] {{1, 6, 410}, {2, 4, 800}};
		System.out.println(new MinCostToRepair().minCostToConnect(6, edges, edgesToRepair));
	}
}
