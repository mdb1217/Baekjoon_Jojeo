import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Engineer {
	
	static class Hole implements Comparable<Hole> {
		double start;
		double end;
		
		Hole(double st, double ed){
			start = st;
			end = ed;
		}
		
		@Override
		public int compareTo(Hole h) {
			if(start > h.start)
				return 1;
			else
				return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		// ���� ���� ��ġ ������ �������� ����
		// ���� ��ġ�� ����ġ�� ������ Ŭ���� �ϳ� ����
		boolean sw = true;
		int index = 0;
		int temp = 0;
		int N;
		int count = 0;
		int L;//������ ����
		double a;
		double standard;
		double start;
		double end;
		ArrayList<Hole> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			a = Double.parseDouble(st.nextToken());
			start = a - 0.5;
			end = a + 0.5;
			list.add(new Hole(start, end));
		}
		
		Collections.sort(list);
		
		while(true) {
			if(index == N-1) {
				if(sw)
					++count;
				break;
			}
			++count;
			standard = list.get(index).start + L;
			for(int i = index + 1; i < N; i++) {
				temp = i;
				sw = false;
				if(list.get(i).end > standard) {
					sw = true;
					break;
				}
			}
			index = temp;
		}
		
		System.out.println(count);
	}

}
