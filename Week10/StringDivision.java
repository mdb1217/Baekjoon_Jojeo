import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class StringDivision {
 
	static String s;
	static HashMap<Character, ArrayList<String>> Map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		// ¹®ÀÚ¿­
		int memo[];
		char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		int N;
		String a;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		memo = new int[s.length() + 1];
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 26; i++)
			Map.put(alpha[i], new ArrayList<>());
		
		for(int i = 0; i < N; i++) {
			a = br.readLine();
			Map.get(a.charAt(0)).add(a);
		}
		
		memo[s.length()] = 1;
		for(int i = s.length() - 1; i >= 0; i--) {
			for(String b : Map.get(s.charAt(i))) {
				if(i + b.length() <= s.length() && s.substring(i, i + b.length()).equals(b) && memo[i + b.length()] == 1) {
					memo[i] = 1;
					break;
				}
			}
		}

		System.out.println(memo[0]);
	}
}
