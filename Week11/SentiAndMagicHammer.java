import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SentiAndMagicHammer {

	public static void main(String[] args) throws IOException {
		// ±¸Çö
		boolean success = false;
		int N;
		int h;
		int Height;
		int T;
		int ans = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Height = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++)
			queue.add(Integer.parseInt(br.readLine()));
		
		for(int i = 0; i < T; i++) {
			h = queue.poll();
			if(h < Height) {
				success = true;
				ans = i;
				break;
			}
			if(h > 1) 
				h = h / 2;
			else {
				queue.add(h);
				break;
			}
			queue.add(h);
		}
		
		if(success) {
			System.out.println("YES");
			System.out.println(ans);
		}
		else {
			h = queue.poll();
			if(h < Height) {
				System.out.println("YES");
				System.out.println(T);
			}
			else {
				System.out.println("NO");
				System.out.println(h);
			}
		}
	}

}
