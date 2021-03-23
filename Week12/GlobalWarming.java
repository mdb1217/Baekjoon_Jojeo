import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GlobalWarming {
	static class Graph {
		int x;
		int y;
		
		Graph(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// ±¸Çö
		Graph g;
		int R, C;
		int min_x = 11;
		int max_x = 0;
		int min_y = 11;
		int max_y = 0;
		int x, y;
		int ocean_cnt;
		StringBuilder sb = new StringBuilder();
		int op_x[] = {0, 0, 1, -1};
		int op_y[] = {1, -1, 0, 0};
		boolean island[][];
		char Map[][];
		Queue<Graph> queue = new LinkedList<>();
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Map = new char[R + 1][C + 1];
		island = new boolean[R + 1][C + 1];
		
		for(int i = 0; i < R; i++) {
			s = br.readLine();
			for(int j = 0; j < C; j++) {
				Map[i + 1][j + 1] = s.charAt(j);
				if(Map[i + 1][j + 1] == 'X')
					queue.add(new Graph(i + 1, j + 1));
			}
		}
		
		while(!queue.isEmpty()) {
			g = queue.poll();
			ocean_cnt = 0;
			for(int i = 0; i < 4; i++) {
				x = g.x + op_x[i];
				y = g.y + op_y[i];
				if(x < 1 || y < 1 || x > R || y > C)
					++ocean_cnt;
				else {
					if(Map[x][y] == '.' && !island[x][y])
						++ocean_cnt;
				}
			}
			if(ocean_cnt >= 3) {
				Map[g.x][g.y] = '.';
				island[g.x][g.y] = true;
			}
			else {
				min_x = Math.min(min_x, g.x);
				max_x = Math.max(max_x, g.x);
				min_y = Math.min(min_y, g.y);
				max_y = Math.max(max_y, g.y);
			}
		}
		
		for(int i = min_x; i <= max_x; i++) {
			for(int j = min_y; j <= max_y; j++)
				sb.append(Map[i][j]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
