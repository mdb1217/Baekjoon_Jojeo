import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DfsBfs {
	static int visited[];
	static int visited2[];
	static int comp[];//중복 방문 방지용..
	static int Map[][];
	static int N;
	static int M;
	static int V;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		//dfs, bfs 알고리즘 사용.
		int n1;
		int n2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		visited = new int[N+1];
		visited2 = new int[N+1];
		comp = new int[N+1];
		Map = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st1.nextToken());
			n2 = Integer.parseInt(st1.nextToken());
			Map[n1][n2] = 1;
			Map[n2][n1] = 1;
		}
		dfs(V);
		System.out.print("\n");
		bfs(V);
	}
	
	static void dfs(int idx) {
		visited[idx] = 1;
		if(comp[idx] == 0 && visited[idx] == 1) {
			System.out.print(idx + " ");
			comp[idx] = 1;
		}
		for(int i = 1 ; i <= N ; i++) {
			if(Map[idx][i] == 1 && visited[i] == 0) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int idx) {
		list.add(idx);
		visited2[idx] = 1;
		while(!list.isEmpty()) {
			idx = list.get(0);
			System.out.print(idx + " ");
			list.remove(0);
			for(int i = 1; i <= N; i++) {
				if(Map[idx][i] == 1 && visited2[i] == 0) {
					list.add(i);
					visited2[i] = 1;
				}
			}
		}
	}

}


