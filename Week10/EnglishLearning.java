import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EnglishLearning {
	
	static class Word implements Comparable<Word> {
		String word;
		int count;

		Word(String a, int b) {
			word = a;
			count = b;
		}
		
		@Override
		public int compareTo(Word target) {
			if(this.count < target.count)
				return 1;
			else if(this.count == target.count) {
				if(this.word.length() < target.word.length())
					return 1;
				else if(this.word.length() == target.word.length())
					return this.word.compareTo(target.word);
				else
					return -1;
			}
			else
				return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		// ¹®ÀÚ¿­
		int N, M;
		String s;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Word> queue = new PriorityQueue<>();
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, Integer> Map = new HashMap<>();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			if(s.length() < M)
				continue;
			if(Map.containsKey(s)) 
				Map.put(s, Map.get(s) + 1);
			else {
				Map.put(s, 1);
				list.add(s);
			}
		}
		
		for(String i : list)
			queue.add(new Word(i, Map.get(i)));
		
		while(!queue.isEmpty())
			sb.append(queue.poll().word + "\n");
		
		bw.write(sb.toString());
		bw.flush();
	}

}
