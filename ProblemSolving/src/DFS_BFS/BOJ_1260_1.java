package DFS_BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_1 {
	static int[][] map;
	static boolean[] visit;
	static int n;
	public static void dfs(int x) {
		visit[x] = true;
		System.out.print((x+1) + " ");
		for(int i = 0;i < n; ++i) {
			if(map[x][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}
	}
	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		visit[x] = true;
		while(!queue.isEmpty()) {
			x = queue.poll();
			System.out.print((x+1) + " ");
			for(int i=0;i<n;i++) { // 다음노드 방문 
				if(map[x][i] ==  1 && visit[i] == false) {
					queue.add(i);
					visit[i] = true;
				}
			}
			
			
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n];
		for(int i=0;i < m;++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x-1][y-1] = 1;
			map[y-1][x-1] = 1;
		}
		dfs(start-1);
		for(int i=0;i<n;i++) {
			visit[i] = false;
		}
		System.out.println();
		bfs(start-1);
	}
}