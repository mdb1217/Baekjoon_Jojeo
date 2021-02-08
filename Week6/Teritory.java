import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Teritory {
	static int op_x[] = {0,0,-1,1};
	static int op_y[] = {-1,1,0,0};
	static int visited[][] = new int[101][101];
	static int M;
	static int N;
	static int K;
	static int t;
	static int cnt = 1;
	public static void main(String[] args) throws IOException {
		//나올 수 있는 영역의 개수와 영역의 넓이를 구하는 공식을 구하여라
		//dfs, bfs 어렵다..
		int x1,x2,y1,y2;
		ArrayList<Integer> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int Map[][] = new int[N][M]; 
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st1.nextToken());
			y1 = Integer.parseInt(st1.nextToken());
			x2 = Integer.parseInt(st1.nextToken());
			y2 = Integer.parseInt(st1.nextToken());
			for(int j = x1; j < x2; j++) {
				for(int k = y1; k < y2; k++) {
					Map[j][k] = 1;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(Map[i][j] == 0 && visited[i][j] == 0) {
					cnt = 1;
					bfs(i,j,Map);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			if(i == list.size()-1)
				System.out.print(list.get(i));
			else
				System.out.print(list.get(i) + " ");
		}
	}
	static void bfs(int x, int y, int Map[][]){
		int op_X = 0, op_Y = 0;
		visited[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			op_X = op_x[i] + x; op_Y = op_y[i] + y;
			if(op_X >= 0 && op_X < N && op_Y >= 0 && op_Y < M)
				if (Map[op_X][op_Y] == 0 && visited[op_X][op_Y] == 0) {
					cnt++;
					bfs(op_X, op_Y, Map);
				}
		}
	}
}

