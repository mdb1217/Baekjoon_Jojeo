import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class EndlessHW {

	public static void main(String[] args) throws IOException {
		// ±¸Çö
		int N;
		int sum = 0;
		int assignment;
		int now_minute = 0;
		int now_score = 0;
		int a, b;
		StringTokenizer st;
		Stack<Integer> score_stack = new Stack<>();
		Stack<Integer> minute_stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			assignment = Integer.parseInt(st.nextToken());
			if(assignment == 1) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(now_minute == 0) {
					now_score = a;
					now_minute = b;
					--now_minute;
					if(now_minute == 0) 
						sum = sum + now_score;
				}
				else {
					score_stack.add(now_score);
					minute_stack.add(now_minute);
					now_score = a;
					now_minute = b;
					--now_minute;
					if(now_minute == 0) 
						sum = sum + now_score;
				}
			}
			else {
				if(now_minute > 0) {
					--now_minute;
					if(now_minute == 0) 
						sum = sum + now_score;
				}
				else {
					if(!minute_stack.isEmpty()) {
						now_minute = minute_stack.pop();
						now_score = score_stack.pop();
						--now_minute;
						if(now_minute == 0) 
							sum = sum + now_score;
					}
				}
			}
		}
		
		System.out.println(sum);
	}

}
