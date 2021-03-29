import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BlackFriday {

	public static void main(String[] args) throws IOException {
		// 그냥 정렬으로 가능할듯..
		boolean success = false;
		int N;
		int C;
		long a, b, c;
		ArrayList<Integer> list = new ArrayList<>();
		boolean map[] = new boolean[100000001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
			map[list.get(i)] = true;
		}
		
		if(map[C])
			System.out.println(1);
		
		else {
			Collections.sort(list);
			for(int i = 0; i < list.size(); i++) {
				a = list.get(i);
				if(a > C)
					break;
				for(int j = i + 1; j < list.size(); j++) {
					b = list.get(j);
					if(a + b == C) {
						success = true;
						break;
					}
					else if(a + b > C)
						break;
					else {
						c = C - (a + b);
						if(map[(int) c] && c != a && c != b) {
							success = true;
							break;
						}
					}
				}
				if(success)
					break;
			}
			System.out.println(success? 1 : 0);
		}
		
	}

}
