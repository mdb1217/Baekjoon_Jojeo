import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DoyoungFood {

	static int N;
	static int min = 1000000000;
	static int sour_taste = 1;
	static int bitter_taste = 0;
	static int material_list[][];
	public static void main(String[] args) throws IOException {
		// 브루트 포스(dfs 이용해서 풀이)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		material_list = new int[N][2];//0은 신맛, 1은 쓴맛
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			material_list[i][0] = Integer.parseInt(st.nextToken());
			material_list[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		System.out.println(min);
	}
	
	static void dfs(int d, int start) {
		if(d != N) {
			for(int i = start; i < N; i++) {
				sour_taste = sour_taste * material_list[i][0];
				bitter_taste = bitter_taste + material_list[i][1];
				min = Math.min(min, Math.abs(sour_taste - bitter_taste));
				dfs(d + 1, i + 1);
				sour_taste = sour_taste / material_list[i][0];
				bitter_taste = bitter_taste - material_list[i][1];
			}
		}
	}

}
