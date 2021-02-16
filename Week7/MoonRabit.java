import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MoonRabit {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// DP문제 맞네연..
		// 나누기 문제..
		// 바텀업
		int N;
		int memo[];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		memo = new int[N + 1];
		Arrays.fill(memo, 100001);
		memo[0] = 0;
		if(N == 0)
			System.out.println(0);
		else {
			for(int i = 1; i <= N; i++) {
				if(i < 2)
					memo[i] = 1;
				else if(i < 5)
					memo[i] = Math.min(memo[i - 1], memo[i - 2]) + 1;
				else if(i < 7) {
					memo[i] = Math.min(memo[i - 1], memo[i - 2]);
					memo[i] = Math.min(memo[i], memo[i - 5]) + 1;
				}
				else {
					memo[i] = Math.min(memo[i - 1], memo[i - 2]);
					memo[i] = Math.min(memo[i], memo[i - 5]);
					memo[i] = Math.min(memo[i], memo[i - 7]) + 1;
				}
			}
			System.out.println(memo[N]);
		}
	}
}
