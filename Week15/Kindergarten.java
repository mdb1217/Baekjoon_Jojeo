import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Kindergarten {

	public static void main(String[] args) throws IOException {
		//티셔츠 비용 : 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이
		//1명만 있는 조는 비용이 들지 않는다.
		//n개로 분할 함. 그리디 알고리즘
		int length;
		int kid;
		int group;
		int prev = 0;
		int start;
		int end;
		int m;
		int sum = 0;
		String shirt;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		kid = Integer.parseInt(st1.nextToken());
		group = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < kid; i++) {
			m = Integer.parseInt(st.nextToken());
			if(i != 0)
				list.add(m - prev);
			prev = m;
		}
		Collections.sort(list);
		for(int j = 0; j < kid - group; j++) {
			sum += list.get(j);
		}
		System.out.println(sum);
	}

}
