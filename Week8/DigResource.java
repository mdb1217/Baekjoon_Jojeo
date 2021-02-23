import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DigResource {
	 
	public static void main(String[] args) throws IOException {
		// DP
		// ╧ыер╬В
		int N;
		int M;
		int Map[][];
		int memo[][];
		int op_X;
		int op_Y;
		int op_x[] = {1,0};
		int op_y[] = {0,1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map = new int[N][M];
		memo = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memo[0][0] = Map[0][0];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < 2; k++) {
					op_X = i + op_x[k];
					op_Y = j + op_y[k];
					if(op_X >= 0 && op_X < N && op_Y >= 0 && op_Y < M)
						memo[op_X][op_Y] = Math.max(memo[op_X][op_Y], memo[i][j] + Map[op_X][op_Y]);
				}
			}
		}
		System.out.println(memo[N - 1][M - 1]);
	}
}