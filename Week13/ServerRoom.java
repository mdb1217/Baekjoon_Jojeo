import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ServerRoom {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//n*n개의 칸이 있다.
		//한 칸에 여러 개의 컴퓨터를 쌓을 수 있음.
		Map<Long, Long> hm = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long com;
		long sum;
		long max = 0;
		long total = 0;
		long left = 0;
		long right;
		long mid;
		long avg;
		long ans = 0;
		int N;
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				com = Long.parseLong(st.nextToken());
				if(hm.containsKey(com)) {
					sum = hm.get(com) + 1;
					hm.put(com, sum);
				}
				else {
					if(com != 0)
						hm.put(com, (long) 1);
				}
				max = Math.max(com, max);
				total = com + total;
			}
		}
		
		right = max;
		if(total % 2 == 1)
			avg = (total / 2) + 1;
		else
			avg = total / 2;
		
		while(left <= right) {
			sum = total;
			mid = (left + right) / 2;
			for(long i = mid + 1; i <= max; i++) {
				if(hm.containsKey(i))
					sum = sum - ((i - mid) * hm.get(i));
			}
			if(sum >= avg) {
				right = mid - 1;
				ans = mid;
			}
			else
				left = mid + 1;
		}
		System.out.println(ans);
	}
}
