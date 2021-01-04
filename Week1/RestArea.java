import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class RestArea {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// �ްԼҸ� ��������!
		// �ްԼҴ� ���� �� ������?
		// ���� Ž������ ���� �� �ִ� �ִ�Ÿ� ����..
		int N, M, L;
		int mid;
		int count;
		int ans = 0;
		int left;
		int right;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//�ްԼ� ����
		M = Integer.parseInt(st.nextToken());//�� �������� �ްԼ�
		L = Integer.parseInt(st.nextToken());//��ӵ��� ����
		
		list.add(0);//���� ����
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		list.add(L);//������
		
		Collections.sort(list);
		left = 0;
		right = L;
		
		while(left <= right) {
			count = 0;
			mid = (left + right) / 2;//�ްԼ� ���� �ִ��� �ּҰ��� ã������~
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
