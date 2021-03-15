import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class InfectionBattle {
	static class Virus implements Comparable<Virus>{
		int x;
		int y;
		int virus;
		
		Virus(int a, int b, int c) {
			x = a;
			y = b;
			virus = c;
		}

		@Override
		public int compareTo(Virus target) {
			return this.virus - target.virus;
		}
	}

	static int N, K;
	static int Map[][];
	static int op_X[] = {0,0,1,-1};//µ¿¼­³²ºÏ
	static int op_Y[] = {1,-1,0,0};//µ¿¼­³²ºÏ
	static PriorityQueue<Virus> queue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// bfs
		int S, X, Y;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				
				if(Map[i][j] > 0)
					queue.add(new Virus(i, j, Map[i][j]));
			}
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < S; i++) {
			if(Map[X - 1][Y - 1] > 0)
				break;
			bfs();
		}
		System.out.println(Map[X - 1][Y - 1]);
	}
	
	static void bfs() {
		Virus v;
		PriorityQueue<Virus> temp_queue = new PriorityQueue<>();
		temp_queue.addAll(queue);
		queue.clear();
		int x, y;
		int op_x, op_y;
		
		while(!temp_queue.isEmpty()) {
			v = temp_queue.poll();
			x = v.x;
			y = v.y;
			
			for(int j = 0; j < 4; j++) {
				op_x = x + op_X[j];
				op_y = y + op_Y[j];
				
				if(op_x >= 0 && op_x < N && op_y >= 0 && op_y < N) {
					if(Map[op_x][op_y] == 0) {
						Map[op_x][op_y] = Map[x][y];
						queue.add(new Virus(op_x, op_y, Map[x][y]));
					}
				} 
			}
		}
	}

}
