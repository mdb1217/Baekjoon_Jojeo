import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MeatShop {
	
	static class MeatPrice implements Comparable<MeatPrice> {
		int weight;
		int price;
		
		MeatPrice(int w, int p){
			weight = w;
			price = p;
		}
		
		@Override
		public int compareTo(MeatPrice m) {
			if(price > m.price)
				return 1;
			else if(price == m.price) {
				return -Integer.compare(weight, m.weight);
			}
			else
				return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		// ���
		// ù������ ����, �ι�°�� ����
		// ���� �� ����(���� ������ ��� ū �� ������ �� ��)
		int prev = -1;
		int weight, price;
		int N, M;//N�� ����� ����, M�� ������ �ʿ��� ����
		int sum = 0;//�̰� M�� ������ ��
		int minPrice = 0;
		int compPrice = 0;
		ArrayList<MeatPrice> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weight = Integer.parseInt(st.nextToken());
			price = Integer.parseInt(st.nextToken());
			list.add(new MeatPrice(weight, price));
		}
		
		Collections.sort(list);//���ݼ� ����
		
		for(int i = 0; i < N; i++) {
			if(prev == list.get(i).price) {
				sum = list.get(i).weight + sum;
				minPrice = list.get(i).price + minPrice;
			}
			else {
				sum = list.get(i).weight + sum;
				minPrice = list.get(i).price;
			}
			prev = list.get(i).price;	
			if(sum >= M) {
				for(int j = i + 1; j < N; j++) {
					if(prev != list.get(j).price) {
						compPrice = list.get(j).price;
						minPrice = Math.min(minPrice, compPrice);
						break;
					}
				}
				break;
			}
		}
		
		if(sum < M)
			System.out.println(-1);
		else 
			System.out.println(minPrice);
	
	}
}
