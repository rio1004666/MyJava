package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KakaoBlind_2021_4 {
	
	public ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	
	public final static int INF = Integer.MAX_VALUE;
		
	static int[] Dijkstra(int n, int src , ArrayList<ArrayList<Node>> graph) {
		int[] cost = new int[n+1];
		Arrays.fill(cost, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(src,0));
		cost[src] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();	
			if(cur.getCost() > cost[cur.getVertex()])continue;
			for(Node nextNode : graph.get(cur.getVertex())) {
				int nextCost = cur.getCost() + nextNode.getCost();
				if(nextCost < cost[nextNode.getVertex()]) {
					cost[nextNode.getVertex()] = nextCost;
					pq.add(new Node(nextNode.getVertex(),nextCost));
				}
			}
			
			
		}
		return cost;
	}
	public int solution(int n, int s, int a, int b, int[][] fares) {
		// 그래프 초기화 
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<Node>());
		}
		for(int[] fare : fares) {
			graph.get(fare[0]).add(new Node(fare[1],fare[2]));
			graph.get(fare[1]).add(new Node(fare[0],fare[2]));
			
		}
		int[] sArr = Dijkstra(n,s,graph);
		int[] aArr = Dijkstra(n,a,graph);
		int[] bArr = Dijkstra(n,b,graph);
		int answer = INF;	
		for(int i = 1; i<= n; i++) {
			answer = Math.min(answer, sArr[i] + aArr[i] + bArr[i]);
		}
		return -1;
	}
}
class Node implements Comparable<Node>{
	private int vertex;
	private int cost;
	public Node(int vertex , int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
	public int getVertex() {
		return this.vertex;
	}
	public int getCost() {
		return this.cost;
	}
	@Override
	public int compareTo(Node next) {
		return this.cost - next.cost;
	}
	
	
	
}