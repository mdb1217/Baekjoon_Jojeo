import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StrangeBar {

	public static void main(String[] args) throws IOException {
		// �������� ����Ž�� ����
		// �� �� ���� Ž���� ���� right���� (���ɸ� �� ���� �� / K(�����)) 
		// ������ 1�δ� �� �̻��� ���� �������ص� ���������°�..
		int N, K;
		long a;
		long drinkSum = 0;//���ɸ� �� ���� ��
		long left = 0;
		long right;
		long mid;
		long ans = 0;
		int comp_sum = 0;
		ArrayList<Long> list = new ArrayList<>();//���ɸ� �뷮 �����
		
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
			mid = (left + right) / 2;//�й��ϴ� ���ɸ��� ��
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
