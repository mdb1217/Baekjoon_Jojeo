import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM {

	static StringBuilder s = new StringBuilder();
	static int N;
	static int M;
	static boolean Visited[];
	public static void main(String[] args) throws IOException {
		// 백트래킹
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		Visited = new boolean[N + 1];
		tracking(0);
	}

	static void tracking(int d) {
		if(d == M) {
			System.out.println(s.toString());
		}
		else {
			for(int i = 1; i <= N; i++) {
				if(!Visited[i]) {
					s.append(i + " ");
					Visited[i] = true;
					tracking(d + 1);
					Visited[i] = false;
					s.delete(s.length() - 2, s.length());
				}
			}
		}
	}
}
