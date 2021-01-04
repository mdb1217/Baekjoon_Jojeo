import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dutbojob {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ����Ž�� �������� �켱���� ť(�߰��ϸ� �ڵ����� �������ִ� ť) �Ế�ô�
		String s;
		String comp = "";
		boolean more_comp = false;
		int N, M;
		int count = 0;
		
		ArrayList<String> list = new ArrayList<>();
		PriorityQueue<String> noListenHeap = new PriorityQueue<String>();
		PriorityQueue<String> noSeeHeap = new PriorityQueue<String>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		N = Integer.parseInt(st.nextToken());//�������ѻ����
		M = Integer.parseInt(st.nextToken());//�������ѻ����
		
		for(int i = 0; i < N; i++) {
			noListenHeap.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			noSeeHeap.add(br.readLine());
		}	
		
		while(!noListenHeap.isEmpty()) {
			s = noListenHeap.poll();
			if(more_comp == true) {
				if(s.compareTo(comp) > 0)
					more_comp = false;
				else if(s.compareTo(comp) == 0){
					++count;
					list.add(s);
					more_comp = false;
					continue;
				}
			}
			while(!noSeeHeap.isEmpty() && more_comp == false) {
				comp = noSeeHeap.poll();
				if(s.compareTo(comp) == 0) {
					++count;
					list.add(s);
					more_comp = false;
					break;
				}
				else if(s.compareTo(comp) < 0) {
					more_comp = true;
					break;
				}
				more_comp = false;
			}
			if(noSeeHeap.isEmpty() && more_comp == false)
				break;
		}
		
		System.out.println(count);
		for(String answer : list) {
			System.out.println(answer);
		}
	}

}
