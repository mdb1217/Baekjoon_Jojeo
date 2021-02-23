import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM2 {
	
	static StringBuilder s = new StringBuilder();
	static int N;
	static int M;
	static boolean finish[][];
	static boolean Visited[];
	public static void main(String[] args) throws IOException {
		// 백트래킹
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		Visited = new boolean[N + 1];
		finish = new boolean[N + 1][N + 1];
		tracking(0, 0);
	}

	static void tracking(int prev, int d) {
		if(d == M) {
			System.out.println(s.toString());
		}
		else {
			for(int i = 1; i <= N; i++) {
				if(!Visited[i] && !finish[i][prev]) {
					s.append(i + " ");
					Visited[i] = true;
					finish[i][prev] = true;
					finish[prev][i] = true;
					tracking(i, d + 1);
					Visited[i] = false;
					s.delete(s.length() - 2, s.length());
				}
			}
			for(int i = prev + 1; i <= N; i++) {
				for(int j = i + 1; j <= N; j++) {
					finish[i][j] = false;
					finish[j][i] = false;
				}
			}
		}
	}
}