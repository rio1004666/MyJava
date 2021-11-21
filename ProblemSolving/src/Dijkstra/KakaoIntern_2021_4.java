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
			// ������ �ߵ��� ���¿����� �湮�Ҽ��� �ְ� �ƴҼ��������Ƿ� 
			/// ��� ���� �ߵ����¿� ���� �湮�� üŷ������Ѵ�. 
			visit[u][state] = true;
			/* ���Ⱑ �ٽ��̴� �����ߵ����θ� ���������Ѵ�. 
			 *  �� ������尡 �ߵ��̴��� �ؽøʿ� ����صξ��ٰ� 
			 *  ���� ����� ��帶�� �ؽøʿ� �ߵ��� ����������� üŷ�ϸ鼭�� ���������� ���������� üŷ�� �� �ִ�. */
			HashMap<Integer,Boolean> tmap = new HashMap<>();
			boolean currTrapped = false;
			for(int i=0 ; i < traps.length;i++) { // �� ������尡 ������ �ߵ��� �������� üũ�غ���. 
				int bit = 1 << i;
				if((state & bit) != 0) {// ������ �̹� �ߵ����մ»���
					if(traps[i] == u) {  // ���� �湮�� ��尡 ��������� 
						state &= ~bit; // ���� ������� �뵹��
					}else { // �װ� �ƴ϶�� �����ߵ��� ���¶�� ����� �ؽøʿ� 
						tmap.put(traps[i], true);
					}
				}else { // �����ߵ��� ���°� �ƴ�
					if(traps[i] == u) { // �����尡 ��������̸� 
						state |= bit; // ���¸� ������� �ߵ��Ȼ��·� �ٲٰ� 
						currTrapped = true; // �����尡 ������ �ߵ��̴ٰ� üŷ
						tmap.put(traps[i], true); // �ؽøʿ� ��� 
					}
				}
			}
			for(int v=1;v<=n;++v) { // �������� �̵��� ���� ������� ���º��ؼ� ���������� �����մ��� ���������� �����մ��� üŷ
			
				if(v == u) continue;
				// ���� �ؽø��� ���� ������ �ߵ��� ���� ���⵵ 1�� �� Ȯ�� 
				boolean nextTrapped = tmap.containsKey(v) ? true:false;
				if(currTrapped == nextTrapped) { // ������� ������尡 ������ �ߵ��̴ٸ� �������̴�.
					// ���� ���� �������� �켱���� ť�� �־��ش�. ����ġ�� �ּڰ����� �־��ٰ��̴�.
					if(Graph[u][v] != INF) { // ���� ����̴ٸ� �湮���ش�. 
						pq.add(new int[] {w + Graph[u][v],v,state});
					}				
				}else { // ������ʸ� ������ �ߵ��̴ٸ� �������̴�. 
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
		for(int i=1;i<=n;i++) { // �׷��� ����(�ʱ�ȭ)
			for(int j=1;j<=n;j++) {
				if(i==j) Graph[i][j] = 0;
				Graph[i][j] = INF; // ��尡 ����Ǿ� ���� �ʴٴ� ���� ǥ�� 
				
			}
		}
		// ���� ��峢�� ������ ���� ����ġ�� ���� 
		for(int[] data : roads) {
			int u = data[0], v = data[1], w = data[2];
			if(w < Graph[u][v]) { // ������ ����ġ���� ������ �����Ѵ�. 
				Graph[u][v] = w;
			}
		}
		
		
		return dijkstra(n,start,end,traps);
	}
	public static void main(String[] args) {
		System.out.print(solution(4,1,4,new int[][]{{1, 2, 1},{3, 2, 1},{2, 4, 1}},new int[]{2,3}));
	}
}
