import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Prefix {

	public static void main(String[] args) throws IOException {
		// startswith�� �켱 ����
		int N;
		int max = 0;
		String s;
		String comp;//�񱳰� �Ǵ� ��Ʈ��
		ArrayList<String> Prefix = new ArrayList<>();//�ܾ��Ʈ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			Prefix.add(s);
		}
		
		max = N;
		Collections.sort(Prefix);
		
		for(int i = 0; i < N-1; i++) {
			comp = Prefix.get(i);
			for(int j = i + 1; j < N; j++) {
				if(Prefix.get(j).startsWith(comp)) {
					max = max - 1;
					break;
				}
			}
		}
		
		System.out.println(max);
	}

}
