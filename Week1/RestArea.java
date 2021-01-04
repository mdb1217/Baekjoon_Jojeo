import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class RestArea {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 휴게소를 세워보자!
		// 휴게소는 어디올 수 있을까?
		// 이진 탐색으로 나올 수 있는 최대거리 상정..
		int N, M, L;
		int mid;
		int count;
		int ans = 0;
		int left;
		int right;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//휴게소 개수
		M = Integer.parseInt(st.nextToken());//더 지으려는 휴게소
		L = Integer.parseInt(st.nextToken());//고속도로 길이
		
		list.add(0);//시작 지점
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		list.add(L);//끝지점
		
		Collections.sort(list);
		left = 0;
		right = L;
		
		while(left <= right) {
			count = 0;
			mid = (left + right) / 2;//휴게소 사이 최댓값의 최소값을 찾기위한~
			for(int i = 1; i <= N+1; i++)
				count += (list.get(i) - list.get(i-1) - 1) / mid;
			if(count > M) {
				left = mid + 1;
			}
			else {
				ans = mid;
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
