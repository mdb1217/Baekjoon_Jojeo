import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sheep {
	static int H, W;
	static int op_x[] = {0,0,1,-1};//동서남북
	static int op_y[] = {1,-1,0,0};//동서남북
	static char Map[][];
	static int Visited[][];
	public static void main(String[] args) throws IOException {
		// dfs로 풀든 bfs로 풀든 상관 x
		int T;
		int cnt;//양의 무리 수
		String s;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0; i < T; i++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			Map = new char[H][W];
			Visited = new int[H][W];
			
			for(int j = 0; j < H; j++) {
				s = br.readLine();
				for(int k = 0; k < W; k++) {
					Map[j][k] = s.charAt(k);
				}
			}
	
			for(int j = 0; j < H; j++) {
				for(int k = 0; k < W; k++) {
					if(Map[j][k] == '#' && Visited[j][k] == 0) {
						++cnt;
						dfs(j, k);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	static void dfs(int x, int y){
		int op_X = 0, op_Y = 0;
		Visited[x][y] = 1;
		for(int i = 0; i < 4; i++) {
			op_X = op_x[i] + x; op_Y = op_y[i] + y;
			if(op_X >= 0 && op_X < H && op_Y >= 0 && op_Y < W)
				if (Map[op_X][op_Y] == '#' && Visited[op_X][op_Y] == 0) {
					Visited[op_X][op_Y] = 1;
					dfs(op_X, op_Y);
				}
		}
	}

}
