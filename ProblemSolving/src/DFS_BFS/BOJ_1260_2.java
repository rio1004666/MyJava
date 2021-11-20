package DFS_BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class BOJ_1260_2 {
	static int[][] map;
	static boolean[] visit;
	static int n,m,v;
	
	static ArrayList<TreeMap<Integer,Integer>> arrayList;
	
	public static void dfs(int x) {
		
		visit[x] = true;
		System.out.print(x + " ");
		TreeMap<Integer,Integer> tmap = arrayList.get(x);
		for(int i : tmap.keySet()) {
			if(visit[i] == false) {
				visit[i] = true;
				dfs(i);
			}
		}
		
		
	}
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visit[i] = true;
		//방문한 위치는 알아야하니까, 그것을 체크하기 위해서 visit가 필요.
		while(!q.isEmpty()){
			int temp = q.poll();
		//첫번째 방문한 위치는 빼주기로 한다.
			System.out.print(temp+" ");
			for(int k =1; k<=n; k++){
				if(map[temp][k]==1 && visit[k]==false){
				q.offer(k);
				visit[k] = true; //true라면 방문을 한거임. ㅇㅇ
				}
			}
		}

		
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		map =new int[n+1][n+1];
		visit = new boolean[n+1];
		arrayList = new ArrayList<>();
		for(int j=0; j<n+1;j++){
		Arrays.fill(map[j], 0);
		arrayList.add(new TreeMap<Integer, Integer>());
		}
		Arrays.fill(visit, false);
		for(int i=0; i<m; i++){
		String edge = br.readLine();
		StringTokenizer st1 = new StringTokenizer(edge," ");
		int a = Integer.parseInt(st1.nextToken());
		int b = Integer.parseInt(st1.nextToken());
		map[a][b]=1;
		map[b][a]=1;
		arrayList.get(a).put(b, a); // 간선에 방향이 없다면 // 간선에 가중치가 있다면 값으로 넣어준다.
		arrayList.get(b).put(a, b); // 반대로 넣어주면 안된다. 
		}
		dfs(v);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(v);

		
		
		
	}
}
