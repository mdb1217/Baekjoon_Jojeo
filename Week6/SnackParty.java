import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnackParty {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// DP
		int list[];//숫자 입력
		int memo[];
		int N;
		int max = 0;
		int comp;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		memo = new int[N];
		list = new int[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
			comp = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(list[i] > list[j]) {
					comp = Math.max(memo[j], comp);
				}
			}
			memo[i] = list[i] + comp;
			max = Math.max(max, memo[i]);
		}
		
		System.out.println(max);
	}

}
