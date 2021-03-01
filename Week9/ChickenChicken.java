import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ChickenChicken {

	static int max = 0;
	static int N, M;
	static int[] happy_list;
	static ArrayList<ArrayList<Integer>> prev_happy_list = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// 브루트 포스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		happy_list = new int[N];
	
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
			prev_happy_list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++)
				list.get(i).add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(0, 0);
		System.out.println(max);
	}

	static void dfs(int d, int start) {
		if(d == 3) {
			int sum = 0;
			for(int i = 0; i < N; i++) 
				sum = sum + happy_list[i];
			max = Math.max(max, sum);
		}
		else {
			for(int i = start; i < M; i++) {
				for(int j = 0; j < N; j++) {
					prev_happy_list.get(d).add(happy_list[j]);
					happy_list[j] = Math.max(list.get(j).get(i), happy_list[j]);
				}
				dfs(d + 1, i + 1);
				for(int j = 0; j < N; j++) 
					happy_list[j] = prev_happy_list.get(d).get(j);
				prev_happy_list.get(d).clear();
			}
		}
	}
}
