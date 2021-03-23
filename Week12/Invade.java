import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Invade {
	static class Graph {
		int x;
		int y;
		
		Graph(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	static Queue<Graph> queue = new LinkedList<>();
	static boolean Visited[][];
	static boolean success = false;
	static char Map[][];
	static int op_x[] = {0, 0, 1, -1};
	static int op_y[] = {1, -1, 0, 0};
	static int M, N;
	public static void main(String[] args) throws IOException {
		// bfs
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Map = new char[M][N];
		Visited = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			s = br.readLine();
			for(int j = 0; j < N; j++) {
				Map[i][j] = s.charAt(j);
				if(i == 0 && Map[i][j] == '0')
					queue.add(new Graph(i, j));
			}
		}
		bfs();
		System.out.println(success? "YES" : "NO");
	}

	static void bfs() {
		Graph g;
		int x;
		int y;
		
		while(!queue.isEmpty()) {
			g = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				x = g.x + op_x[i];
				y = g.y + op_y[i];
				
				if(x >= 0 && y >= 0 && x < M && y < N) {
					if(Map[x][y] == '0' && !Visited[x][y]) {
						if(x == M - 1) {
							success = true;
							break;
						}
						queue.add(new Graph(x, y));
						Visited[x][y] = true;
					}
				}
			}
			if(success)
				break;
		}
	}
}
