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
		// 구멍 시작 위치 순으로 오름차순 정렬
		// 시작 위치와 끝위치를 가지는 클래스 하나 생성
		boolean sw = true;
		int index = 0;
		int temp = 0;
		int N;
		int count = 0;
		int L;//테이프 길이
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
