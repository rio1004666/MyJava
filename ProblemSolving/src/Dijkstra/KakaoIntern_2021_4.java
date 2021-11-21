package Dijkstra;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KakaoIntern_2021_4 {
	
	private final static int MAX_N = 1001;
	private final static int INF = Integer.MAX_VALUE;
	
	static int[][] Graph = new int[MAX_N][MAX_N];
	static int dijkstra(int n, int start, int end, int[] traps) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
		boolean[][] visit = new boolean[MAX_N][1<<10];
		pq.add(new int[] {0, start, 0});
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int w = cur[0], u = cur[1] , state = cur[2];
			if(u == end) return w;
			if(visit[u][state])continue;
			// 함정이 발동된 상태에따라 방문할수도 있고 아닐수도있으므로 
			/// 모든 함정 발동상태에 따라 방문을 체킹해줘야한다. 
			visit[u][state] = true;
			/* 여기가 핵심이다 함정발동여부를 기록해줘야한다. 
			 *  각 함정노드가 발동됫는지 해시맵에 기록해두엇다가 
			 *  그후 연결된 노드마다 해시맵에 발동된 함정노드인지 체킹하면서이 역방향인지 정방향인지 체킹할 수 있다. */
			HashMap<Integer,Boolean> tmap = new HashMap<>();
			boolean currTrapped = false;
			for(int i=0 ; i < traps.length;i++) { // 각 함정노드가 함정이 발동된 상태인지 체크해본다. 
				int bit = 1 << i;
				if((state & bit) != 0) {// 함정이 이미 발동되잇는상태
					if(traps[i] == u) {  // 현재 방문한 노드가 함정노드라면 
						state &= ~bit; // 상태 원래대로 대돌림
					}else { // 그게 아니라면 함정발동된 상태라고 등록함 해시맵에 
						tmap.put(traps[i], true);
					}
				}else { // 함정발동한 상태가 아님
					if(traps[i] == u) { // 현재노드가 함정노드이면 
						state |= bit; // 상태를 함정노드 발동된상태로 바꾸고 
						currTrapped = true; // 현재노드가 함정이 발동됫다고 체킹
						tmap.put(traps[i], true); // 해시맵에 등록 
					}
				}
			}
			for(int v=1;v<=n;++v) { // 다음으로 이동할 노드와 현재노드와 상태비교해서 정방향으로 갈수잇는지 역방향으로 갈수잇는지 체킹
			
				if(v == u) continue;
				// 위의 해시맵을 통해 함정이 발동된 노드들 복잡도 1로 다 확인 
				boolean nextTrapped = tmap.containsKey(v) ? true:false;
				if(currTrapped == nextTrapped) { // 현재노드와 다음노드가 함정이 발동됫다면 정방향이다.
					// 다음 노드로 가기위해 우선순위 큐에 넣어준다. 가중치가 최솟값부터 넣어줄것이다.
					if(Graph[u][v] != INF) { // 길이 연결됫다면 방문해준다. 
						pq.add(new int[] {w + Graph[u][v],v,state});
					}				
				}else { // 어느한쪽만 함정이 발동됫다면 역방향이다. 
					if(Graph[v][u] != INF) {
						pq.add(new int[] {w + Graph[v][u],v,state});
					}
				}
				
				
			}
			
		}
		return INF;
	}
	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
		int answer = 0;
		for(int i=1;i<=n;i++) { // 그래프 생성(초기화)
			for(int j=1;j<=n;j++) {
				if(i==j) Graph[i][j] = 0;
				Graph[i][j] = INF; // 노드가 연결되어 있지 않다는 것을 표현 
				
			}
		}
		// 이제 노드끼리 연결할 거임 가중치도 있음 
		for(int[] data : roads) {
			int u = data[0], v = data[1], w = data[2];
			if(w < Graph[u][v]) { // 기존의 가중치보다 작으면 갱신한다. 
				Graph[u][v] = w;
			}
		}
		
		
		return dijkstra(n,start,end,traps);
	}
	public static void main(String[] args) {
		System.out.print(solution(4,1,4,new int[][]{{1, 2, 1},{3, 2, 1},{2, 4, 1}},new int[]{2,3}));
	}
}
