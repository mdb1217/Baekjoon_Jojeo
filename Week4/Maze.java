import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Maze {
	
	static class Graph {
		int x;
		int y;
		int dis;//�Ÿ�
		
		Graph(int a, int b, int c) {
			x = a;
			y = b;
			dis = c;
		}
	}

	static int Map[][];
	static int Distance[][];//�� ��ġ�� �ִ� �Ÿ��� ���ϱ� ���� �迭
	static int Visited[][];//�湮 ����
	static int op_x[] = {0,0,1,-1};//��������
	static int op_y[] = {1,-1,0,0};//��������
	public static void main(String[] args) throws IOException {
		//bfs �ִܰŸ� Ž�� ����
		int N, M;
		String s;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map = new int[N+1][M+1];//�ε��� 1,1���� �����ؼ� N,M���� �� �� �ְ� �ϱ�����
		Distance = new int[N+1][M+1];
		Visited = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			s = br.readLine();
			for(int j = 0; j < M; j++) {
				Map[i][j+1] = s.charAt(j) - '0';
			}
		}
		
		bfs(N, M);
		System.out.println(Distance[N][M]);
	}
	
	static void bfs(int N, int M) {
		int x = 0, y = 0;
		int cnt = 1;
		int op_X, op_Y;
		boolean sw = false;//M,N���޽� �ٷ� ���������� ����
		ArrayList<Graph> list = new ArrayList<>(); 
		list.add(new Graph(1, 1, cnt));
		Distance[1][1] = cnt;
		Visited[1][1] = 1;
		
		while(!list.isEmpty()) {
			cnt = list.get(0).dis + 1;
			x = list.get(0).x;
			y = list.get(0).y;
			list.remove(0);
			for(int i = 0; i < 4; i++) {
				op_X = op_x[i] + x; 
				op_Y = op_y[i] + y;
				if(op_X > 0 && op_X <= N && op_Y > 0 && op_Y <= M) {
					if(Map[op_X][op_Y] == 1 && Visited[op_X][op_Y] == 0) {
						list.add(new Graph(op_X, op_Y, cnt));
						Visited[op_X][op_Y] = 1;
						Distance[op_X][op_Y] = cnt;
						if(op_X == N && op_Y == M) {
							sw = true;
							break;
						}
					}
				}
			}
			if(sw) {
				break;
			}
		}
	}

}
