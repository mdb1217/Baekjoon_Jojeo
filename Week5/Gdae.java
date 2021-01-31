import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gdae {
	static class Graph {
		int comp;
		int cnt;
		
		Graph(int a, int b) {
			comp = a;
			cnt = b;
		}
	}
	
	static int start;
	static int end;
	static boolean sw = false;//end 도달시 바로 나가기위한 변수
	static int cnt = 0;
	static int N, M;
	static int Map[][];
	static int Visited[];
	public static void main(String[] args) throws IOException {
		// 최소횟수는 bfs ㄱㄱ
		int x, y;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map = new int[N+1][N+1];
		Visited = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Map[x][y] = 1;
			Map[y][x] = 1;
		}
		
		bfs();
		
		if(sw)
			System.out.println(cnt);
		else
			System.out.println(-1);
		
	}
	
	static void bfs() {
		int comp;
		ArrayList<Graph> list = new ArrayList<>(); 
		list.add(new Graph(start, 0));
		
		while(!list.isEmpty()) {
			comp = list.get(0).comp;
			cnt = list.get(0).cnt;
			list.remove(0);
			if(comp == end) {
				sw = true;
				break;
			}
			for(int i = 1; i <= N; i++) {
				if(Map[comp][i] == 1 && Visited[i] == 0) {
					list.add(new Graph(i, cnt + 1));
					Visited[i] = 1;
				}
			}
			if(sw) {
				break;
			}
		}
	}
}