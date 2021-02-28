import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CowFly {

	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	static int N, M;
	static int sum = 0;
	static int list[];
	static boolean Visited[];
	public static void main(String[] args) throws IOException {
		// 백트래킹
		// 제곱근까지만~ 나눠주기~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		list = new int[N];
		Visited = new boolean[N];
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			list[i] = Integer.parseInt(st.nextToken());
		
		dfs(0, 0);
		if(queue.isEmpty())
			System.out.println(-1);
		else {
			while(!queue.isEmpty())
				System.out.print(queue.poll() + " ");
		}
	}
	
	static void dfs(int d, int start) {
		if(d == M) {
			boolean prime = true;
			int limit = (int) Math.sqrt(sum);
			for(int i = 2; i <= limit; i++) {
				if(sum % i == 0) {
					prime = false;
					break;
				}
			}
			if(prime) {
				if(!queue.contains(sum))
					queue.add(sum);
			}
		}
		else {
			for(int i = start; i < N; i++) {
				sum = list[i] + sum;
				dfs(d + 1, i + 1);
				sum = sum - list[i];
			}
		}
	}

}
