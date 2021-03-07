import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Guminsu {

	public static void main(String[] args) throws IOException {
		// 브루트 포스
		int cnt = 0;
		long A, B;
		int limit;
		long next;
		long num;
		Queue<Long> queue = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		queue.add((long) 0);
		while(!queue.isEmpty()) {
			limit = queue.size();
			for(int j = 0; j < limit; j++) {
				num = queue.poll();
				
				next = num * 10 + 4;
				if(next <= B) {
					if(next >= A)
						++cnt;
					queue.add(next);
				}
				
				next = num * 10 + 7;
				if(next <= B) {
					if(next >= A)
						++cnt;
					queue.add(next);
				}
			}
			
		}
		System.out.println(cnt);
	}
}
