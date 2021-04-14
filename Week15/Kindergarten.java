import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Kindergarten {

	public static void main(String[] args) throws IOException {
		//Ƽ���� ��� : ���� Ű�� ū ������ ���� Ű�� ���� ������ Ű ����
		//1�� �ִ� ���� ����� ���� �ʴ´�.
		//n���� ���� ��. �׸��� �˰���
		int length;
		int kid;
		int group;
		int prev = 0;
		int start;
		int end;
		int m;
		int sum = 0;
		String shirt;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		kid = Integer.parseInt(st1.nextToken());
		group = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < kid; i++) {
			m = Integer.parseInt(st.nextToken());
			if(i != 0)
				list.add(m - prev);
			prev = m;
		}
		Collections.sort(list);
		for(int j = 0; j < kid - group; j++) {
			sum += list.get(j);
		}
		System.out.println(sum);
	}

}
