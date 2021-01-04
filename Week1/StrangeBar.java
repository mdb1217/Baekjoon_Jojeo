import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StrangeBar {

	public static void main(String[] args) throws IOException {
		// 전형적인 이진탐색 문제
		// 좀 더 빠른 탐색을 위해 right값은 (막걸리 다 더한 값 / K(사람수)) 
		// 어차피 1인당 이 이상의 값은 가질라해도 가질수없는걸..
		int N, K;
		long a;
		long drinkSum = 0;//막걸리 다 더한 값
		long left = 0;
		long right;
		long mid;
		long ans = 0;
		int comp_sum = 0;
		ArrayList<Long> list = new ArrayList<>();//막걸리 용량 저장소
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			a = Long.parseLong(br.readLine());
			drinkSum += a;
			list.add(a);
		}
		
		right = drinkSum / K;
		
		while(left <= right) {
			mid = (left + right) / 2;//분배하는 막걸리의 양
			if(mid != 0) {
				comp_sum = 0;
				for(long drink : list) {
					comp_sum += (drink / mid);
				}
			}
			if(comp_sum >= K) {
				ans = mid;
				left = mid + 1;
			}
			else if(comp_sum < K) {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
