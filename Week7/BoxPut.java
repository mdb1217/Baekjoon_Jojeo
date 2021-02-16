import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoxPut {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// DP
		int list[];//숫자 입력
		int memo[];
		int n;
		int max = 0;
		int comp;
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		n = Integer.parseInt(br.readLine());
		memo = new int[n];
		list = new int[n];
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			comp = 1;
			for(int j = i - 1; j >= 0; j--) {
				if(list[i] > list[j]) {
					comp = Math.max(memo[j] + 1, comp);
				}
			}
			memo[i] = comp;
			max = Math.max(max, memo[i]);
		}
			
		System.out.println(max);
	}

}